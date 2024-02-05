/*
 * Desarrollado por José Luis Espinoza Jolón
 * jespinozajolon@gmail.com
 * Enero - 2024
 */
package Analisador;
import static Analisador.Tokens.*;

%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ \t\r\n]+




%line
%column
%ignorecase

%{
    public String lexeme;
%}
%%




program |
end program |
end |
var |
arr |
console |
print |
column |
@ |
::  {lexeme=yytext(); return RESERVADA;}

char |
double {lexeme=yytext(); return Tipo_dato;}



sum |
res |
mul |
div | 
mod {lexeme=yytext(); return Aritmeticas;}


media |
mediana |
moda |
varianza {lexeme=yytext(); return Estadisticas;}


graphpie |
titulo |
label |
grapPie |
graphbar |
ejex |
ejey |
titulox |
tituloy |
grapbar |
graphline |
grapline |
histogram |
exec {lexeme=yytext(); return Grafica;}



"=" {lexeme=yytext(); return Igual;}
"+" {lexeme=yytext(); return Suma;}
"," {lexeme=yytext(); return Coma;}
"-" {lexeme=yytext(); return Resta;}
"*" {lexeme=yytext(); return Multiplicacion;}
"/" {lexeme=yytext(); return Division;}
"(" {lexeme=yytext(); return Parentesis_a;}
")" {lexeme=yytext(); return Parentesis_c;}
"{" {lexeme=yytext(); return Llave_a;}
"}" {lexeme=yytext(); return Llave_c;}
":" {lexeme=yytext(); return Dos_puntos;}
"<-" {lexeme=yytext(); return Reserve;}
";" {lexeme=yytext(); return P_coma;}
"[" {lexeme=yytext(); return Parent_a;}
"]" {lexeme=yytext(); return Parent_c;}
"." {lexeme=yytext(); return Punto;}
"“" {lexeme=yytext(); return C_dobles_a;}
"”" {lexeme=yytext(); return C_dobles_c;}
"“"([^\n]+)"”" {lexeme=yytext(); return Titulo;} 



{espacio} {/*Ignore*/}

/* Comentarios */
( "!"(.)* ) {/*Ignore*/}

/* multi comentario */
"<!"([^!]|\n|!([^>]|[^>!]))*"!>" {/*Ignore*/}


{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
(-?{D}+\.?{D}*)|{D}*\.{D}+ {lexeme=yytext(); return Numero;}

 . { 
    lexeme=yytext();
    int linea = yyline;
    int columna = yycolumn;
    return ERROR;
}
