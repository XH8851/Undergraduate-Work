#两个问题：前30%的收益没有解决；Sharpe ratio的公式分母到底用哪一种

library(readxl)

name_list = c("ps", "pe", "pcf", "pb", "div", "roic1", "evebit1")
result = as.data.frame(name_list)

##test part

data0 = read_excel(path = "roic.xlsx", sheet = "Sheet1")
data2 = read_excel(path = "pb.xlsx", sheet = "Sheet1")

data1 = read.csv(file = "risk_free.csv", header = T)

data1 = data1[,3]

value_ = data0$BenchMark
market = data0$BenchMark2

value_ = value_*252
market = market*252

t.test(value_, market,alternative= "less")

sharpe = value_-market
t.test(sharpe,  alternative="greater")


##formal part

for(i in name_list){
  file_name = paste(i, "xlsx", sep = ".")
  num = which(result == i)
  data0 = read_excel(path = file_name, sheet = "Sheet1")
  data1 = data0[,3:4]
  
  if(i == "roic1")
    value_ = data0$Group10
  else value_ = data0$Group1
  market = data0$BenchMark
  value_ = value_*252
  market = market*252
  sharpe = value_-market
  
  result = t.test(sharpe,  alternative="greater")
  print(i)
  print(result$p.value)
  print(result$estimate)
}

#order: pb ps pe pcf div
####

library(tseries)
risk_free = 0.01254141611

sharpe_ratio <- function(raw_data){
  
  new_sd = 0
  for(j in raw_data){
    new_sd = new_sd + (j-risk_free)^2
  }
  new_sd = new_sd/length(raw_data)
  new_sd = new_sd^0.5
  x = (mean(raw_data) - risk_free)/new_sd
  
  return(x)
}

sortino_ratio <- function(raw_data){
  
  save_data = raw_data[raw_data<risk_free]
  n = length(raw_data) 
  
  new_sd = 0
  for(j in save_data){
    new_sd = new_sd + (j-risk_free)^2
  }
  new_sd = new_sd/(n-1)
  new_sd = new_sd^0.5
  x = (mean(raw_data) - risk_free)/new_sd
  
  return(x)
}

for(i in name_list){
  file_name = paste(i, "xlsx", sep = ".")
  num = which(result == i)
  data0 = read_excel(path = file_name, sheet = "Sheet1")
  data1 = data0[,3:6]
  data2 = as.matrix(data1[,2])
  data2 = as.vector(data2)
  data3 = as.vector(as.matrix(data0[,13]))
  data4 = as.vector(as.matrix(data0[,3]))
  result[num,2] = sharpe_ratio(data2)
  result[num,3] = sortino_ratio(data2)
  result[num,4] = sharpe_ratio(data3)
  result[num,5] = sortino_ratio(data3)
  result[num,6] = sharpe_ratio(data4)
  result[num,7] = sortino_ratio(data4)
}

names(result) = c("factor", "group1_sharpe ratio",
                  "group1_sortino ratio", "group10_sharpe ratio", 
                  "group10_sortino ratio", "benchmark_sharpe ratio",
                  "benchmark_sortino ratio")

library(writexl)
write_xlsx(result, path = "s&s ratio.xlsx")
