package Analisador;
import java_cup.runtime.Symbol;

%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ \t\r\n]+

%{
    public Symbol symbol(int type, Object value){
        return new Symbol(type, yyline,yycolumn,value);
    }
    public Symbol symbol(int type){
        return new Symbol(type, yyline,yycolumn);
    }
%}

%%

program {return new Symbol(sym.Program, yychar, yyline, yytext());}
end     {return new Symbol(sym.End, yychar, yyline, yytext());}
var     {return new Symbol(sym.Var, yychar, yyline, yytext());}
arr  {return new Symbol(sym.Arr, yychar, yyline, yytext());}
console    {return new Symbol(sym.Console, yychar, yyline, yytext());}
print     {return new Symbol(sym.Print, yychar, yyline, yytext());}
column     {return new Symbol(sym.Column, yychar, yyline, yytext());}
char     {return new Symbol(sym.Tipo_char, yychar, yyline, yytext());}
double     {return new Symbol(sym.Tipo_double, yychar, yyline, yytext());}
sum     {return new Symbol(sym.A_sum, yychar, yyline, yytext());}
res     {return new Symbol(sym.A_res, yychar, yyline, yytext());}
mul     {return new Symbol(sym.A_mul, yychar, yyline, yytext());}
div     {return new Symbol(sym.A_div, yychar, yyline, yytext());}
mod     {return new Symbol(sym.A_mod, yychar, yyline, yytext());}
min     {return new Symbol(sym.E_min, yychar, yyline, yytext());}
max     {return new Symbol(sym.E_max, yychar, yyline, yytext());}
media   {return new Symbol(sym.E_media, yychar, yyline, yytext());}
mediana {return new Symbol(sym.E_mediana, yychar, yyline, yytext());}
moda    {return new Symbol(sym.E_moda, yychar, yyline, yytext());}
varianza {return new Symbol(sym.E_varianza, yychar, yyline, yytext());}
graphpie {return new Symbol(sym.G_graphpie, yychar, yyline, yytext());}
titulo   {return new Symbol(sym.G_titulo, yychar, yyline, yytext());}
label  {return new Symbol(sym.G_label, yychar, yyline, yytext());}
grapPie    {return new Symbol(sym.G_grapPie, yychar, yyline, yytext());}
graphbar {return new Symbol(sym.G_graphbar, yychar, yyline, yytext());}
ejex    {return new Symbol(sym.G_ejex, yychar, yyline, yytext());}
ejey    {return new Symbol(sym.G_ejey, yychar, yyline, yytext());}
titulox {return new Symbol(sym.G_titulox, yychar, yyline, yytext());}
tituloy {return new Symbol(sym.G_tituloy, yychar, yyline, yytext());}
grapbar {return new Symbol(sym.G_grapbar, yychar, yyline, yytext());}
graphline   {return new Symbol(sym.G_graphline, yychar, yyline, yytext());}
grapline  {return new Symbol(sym.G_grapline, yychar, yyline, yytext());}
histogram {return new Symbol(sym.G_histogram, yychar, yyline, yytext());}
values {return new Symbol(sym.G_values, yychar, yyline, yytext());}
exec {return new Symbol(sym.G_exec, yychar, yyline, yytext());}
"=" {return new Symbol(sym.Igual, yychar, yyline, yytext());}
"+" {return new Symbol(sym.Suma, yychar, yyline, yytext());}
"," {return new Symbol(sym.Coma, yychar, yyline, yytext());}
"-" {return new Symbol(sym.Resta, yychar, yyline, yytext());}
"*" {return new Symbol(sym.Multiplicacion, yychar, yyline, yytext());}
"/" {return new Symbol(sym.Division, yychar, yyline, yytext());}
"(" {return new Symbol(sym.Parentesis_a, yychar, yyline, yytext());}
")" {return new Symbol(sym.Parentesis_c, yychar, yyline, yytext());}
"{" {return new Symbol(sym.Llave_a, yychar, yyline, yytext());}
"}" {return new Symbol(sym.Llave_c, yychar, yyline, yytext());}
":" {return new Symbol(sym.Dos_puntos, yychar, yyline, yytext());}
"<-" {return new Symbol(sym.Reserve, yychar, yyline, yytext());}
";" {return new Symbol(sym.P_coma, yychar, yyline, yytext());}
"[" {return new Symbol(sym.Parent_a, yychar, yyline, yytext());}
"]" {return new Symbol(sym.Parent_c, yychar, yyline, yytext());}
"." {return new Symbol(sym.Punto, yychar, yyline, yytext());}
"“" {return new Symbol(sym.C_dobles_a, yychar, yyline, yytext());}
"”" {return new Symbol(sym.C_dobles_c, yychar, yyline, yytext());}
"@" {return new Symbol(sym.Arroba, yychar, yyline, yytext());}
"::" {return new Symbol(sym.Doble_puntos, yychar, yyline, yytext());}
{L}({L}|{D})* {return new Symbol(sym.Identificador, yychar, yyline, yytext());}
{D}+("."{D}+)? {return new Symbol(sym.Numero, yychar, yyline, yytext());}
. {return new Symbol(sym.ERROR, yychar, yyline, yytext());}
