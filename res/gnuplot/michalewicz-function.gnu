pow(x,n) = x**n
set xrange [0:4]
set yrange [0:4]
set zrange [-2:1]
m = 10
splot -(sin(x)*pow(sin(pow(x,2)/pi),2*m)+sin(y)*pow(sin((2*pow(y,2))/pi),2*m))