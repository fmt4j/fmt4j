grammar fmt4j;

r: 'hello' ID;
ID: [a-z]+;
WS: [ \t\r\n]+ -> skip;