*申明面板
sort id time
egen n=rowmiss(Yield Volatility Turnover case X)

egen m=rowmiss(_all)
drop if n>0

xtset id trade_date
rdplot Yield WID,  p(0) ci(95) shade
rdplot Volatility  WID,  p(0) ci(95) shade

rdplot Volatility t, c(154)

rd Yield t,z0(154) gr mbw()

cmogram Yield t,cut(152) scatter lineat(0) qfitci
cmogram Volatility t,cut(152) scatter lineat(0) qfitci

cmogram Yield WID,cut(0) scatter lineat(0) qfitci
cmogram Volatility WID,cut(0) scatter lineat(0) qfitci


 **将字符串证券代码转为数值型
destring id,replace force

destring time,replace

generate trade_date=date(time, "YMD")
 format trade_date %td

*生产疫情虚拟变量***
gen dt=0
replace dt=1 if trade_date>21925 //交易时间晚于2020.1.11

gen month=month(trade_date)    //提取月份
encode time ,gen(t) //将交易日期转换成纯数值
global xx "Turnover" "number"
//1-152-242
//gen et=0
//replace et=1 if t>122 //交易时间晚于2020.12.11的三十天
//gen dt=0
//replace dt=1 if t>152 //交易时间晚于2020.1.11的三十天
//drop dt
//gen period=t-152
//drop period

sort id time

xtset id trade_date

gen WID = floor((trade_date - 21925)/7)
replace WID = floor((trade_date - 21925)/14)

gen WID = int((t - 152)/7)

* TIME MODEL

gen TIME1 = WID
gen TIME2 = WID * WID
gen TIME3 = WID * WID * WID
gen TIME4 = WID * WID * WID * WID
gen TIME1_INS = TIME1 * dt
gen TIME2_INS = TIME2 * dt
gen TIME3_INS = TIME3 * dt
gen TIME4_INS = TIME4 * dt

* (1) Result: Single-Group Interrupted Time-Series (12 Weeks Before & 12 Weeks After)

* Fixed Effects

//xtset SID TID
xtreg Yield dt TIME1 TIME2 TIME3 TIME1_INS TIME2_INS TIME3_INS if WID>=-8 & WID<=8, re vce(cluster id)
//est sto m1
xtreg Volatility dt TIME1 TIME2 TIME3 TIME1_INS TIME2_INS TIME3_INS if WID>=-8 & WID<=8, re vce(cluster id)
//est sto m2
reg2docx m1 m2 using "Single-Group Interrupted Time-Series-FE.docx", replace 
scalars(N r2(%9.3f) r2_w(%9.3f) F(%9.3f))
b(%9.4f) se(%9.4f) 
pagesize(A4) font("Times New Roman","11","black")   

* Random Effects

xtreg Yield dt TIME1 TIME2 TIME3 TIME4 TIME1_INS TIME2_INS TIME3_INS TIME4_INS if WID>=-8 & WID<=7, re vce(cluster id)
est sto m1
xtreg Volatility dt TIME1 TIME2 TIME3 TIME4 TIME1_INS TIME2_INS TIME3_INS TIME4_INS if WID>=-8 & WID<=7, re vce(cluster id)
est sto m2
//ssc install reg2docx,replace 
reg2docx m1 m2 using "Single-Group Interrupted Time-Series-RE.docx", replace
	scalars(N r2(%9.3f) r2_w(%9.3f) F(%9.3f))
	b(%9.4f) se(%9.4f) 
	pagesize(A4) font("Times New Roman","11","black") 

//xtset SID TID
xtreg Volatility dt TIME1 TIME2 TIME3 TIME1_INS TIME2_INS TIME3_INS if WID>=-12 & WID<=12, re
outreg2 using "Single-Group Interrupted Time-Series-RE.docx", symbol(***, **, *) dec(3) replace

* Hausman Test

xtset id trade_date
xtreg Yield dt $xx, fe
estimates store FE
xtreg Yield dt $xx, re
estimates store RE
hausman FE RE
outreg2 using "Hausman Test - FE.docx"

//结果是选择固定效应模型

xtset id trade_date
xtreg Volatility dt $xx, fe
estimates store FE
xtreg Volatility dt $xx, re
estimates store RE
hausman FE RE


xtset id trade_date
xtreg Yield dt TIME1 TIME2 TIME3 TIME1_INS TIME2_INS TIME3_INS if WID>=-8 & WID<=7, fe
estimates store FE
xtreg Yield dt TIME1 TIME2 TIME3 TIME1_INS TIME2_INS TIME3_INS if WID>=-8 & WID<=7, re
estimates store RE
hausman FE RE
est sto m1
reg2docx m1 using "Hausman Test - RD.docx"

xtset id trade_date
xtreg Volatility dt TIME1 TIME2 TIME3 TIME1_INS TIME2_INS TIME3_INS if WID>=-8 & WID<=7, fe
estimates store FE
xtreg Volatility dt TIME1 TIME2 TIME3 TIME1_INS TIME2_INS TIME3_INS if WID>=-8 & WID<=7, re
estimates store RE
hausman FE RE

xtset SID TID
xtreg S_REV INS TIME1 TIME2 TIME3 TIME1_INS TIME2_INS TIME3_INS if WID>=-12 & WID<=12, fe
estimates store FE
xtreg S_REV INS TIME1 TIME2 TIME3 TIME1_INS TIME2_INS TIME3_INS if WID>=-12 & WID<=12, re
estimates store RE
hausman FE RE

* (2) Result: Short-Run Analysis (All Weeks Before & 8 Weeks After)

* Fixed Effects
//xtset BID TID

xtreg Yield dt Turnover cases X i.month if WID >= -11, fe vce(cluster id)
est sto m1
xtreg Volatility dt Turnover cases r i.month if WID <= 14, fe vce(cluster id)
est sto m3

//global xx "Turnover" 
//xtreg Yield dt $xx i.month if WID<=14, re
//outreg2 using Stock-ShortRun-FE.doc, symbol(***, **, *) dec(3) replace

* (3) Result: Long-Run Analysis (All Weeks Before & All Weeks After)

* Fixed Effects

//xtreg Yield dt $xx i.month, fe
//xtreg Volatility dt $xx i.month, fe
//outreg2 using Stock-LongRun-FE.doc, symbol(***, **, *) dec(3) replace

xtreg Yield dt $xx i.month, fe vce(cluster id)
est sto m2
xtreg Volatility dt $xx i.month, fe vce(cluster id)
est sto m4

reg2docx m1 m2 m3 m4 using "Short&LongRun-FE.docx", replace 
scalars(N r2(%9.3f) r2_w(%9.3f) F(%9.3f))      ///
indicate(时间效应="*month")  

xtset BID TID
xtreg B_EXP INS B_RVW_CNT B_RVW_STR B_RVW_STR_SD B_CPN B_REG i.TID, fe
outreg2 using Buyer-LongRun-FE.doc, symbol(***, **, *) dec(3) replace

