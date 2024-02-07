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

%ignorecase

%{
    public String lexeme;
%}
%%



program {lexeme=yytext(); return Program;}
end {lexeme=yytext(); return End;}
var {lexeme=yytext(); return Var;}
arr {lexeme=yytext(); return Arr;}
console {lexeme=yytext(); return Console;}
print {lexeme=yytext(); return Print;}
column {lexeme=yytext(); return Column;}    
"@" {lexeme=yytext(); return Arroba;}
"::"  {lexeme=yytext(); return Doble_puntos;}

(char|double) {lexeme=yytext(); return Tipo_dato;}




//A :: aritmeticas
sum {lexeme=yytext(); return A_sum;}
res {lexeme=yytext(); return A_res;}
mul {lexeme=yytext(); return A_mul;}
div {lexeme=yytext(); return A_div;} 
mod {lexeme=yytext(); return A_mod;}

//E :: estadisticas
media {lexeme=yytext(); return E_media;}
mediana {lexeme=yytext(); return E_mediana;}
moda {lexeme=yytext(); return E_moda;}
varianza {lexeme=yytext(); return E_varianza;}

//G :: grafica
graphpie {lexeme=yytext(); return G_graphpie;}
titulo {lexeme=yytext(); return G_titulo;}
label {lexeme=yytext(); return G_label;}
grapPie {lexeme=yytext(); return G_grapPie;}
graphbar {lexeme=yytext(); return G_graphbar;}
ejex {lexeme=yytext(); return G_ejex;}
ejey {lexeme=yytext(); return G_ejey;}
titulox {lexeme=yytext(); return G_titulox;}
tituloy {lexeme=yytext(); return G_tituloy;}
grapbar {lexeme=yytext(); return G_grapbar;}
graphline {lexeme=yytext(); return G_graphline;}
grapline {lexeme=yytext(); return G_grapline;}
histogram {lexeme=yytext(); return G_histogram;}
exec {lexeme=yytext(); return G_exec;}



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


{espacio} {/*Ignore*/}

/* Comentarios */
( "!"(.)* ) {/*Ignore*/}

/* multi comentario */
"<!"([^!]|\n|!([^>]|[^>!]))*"!>" {/*Ignore*/}


{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
(-?{D}+\.?{D}*)|{D}*\.{D}+ {lexeme=yytext(); return Numero;}

 . {lexeme=yytext(); return ERROR;}
