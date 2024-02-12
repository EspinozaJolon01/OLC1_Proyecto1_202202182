/*
 * Desarrollado por José Luis Espinoza Jolón
 * jespinozajolon@gmail.com
 * Enero - 2024
 */
package Analisador;
import java_cup.runtime.Symbol;
import Lista.Lista_errores;
import Lista.Lista_tokens;
import Clases.Errores;
import Clases.Tokens_L;

%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
%column
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

    Lista_errores lista = new Lista_errores();
    Lista_tokens lista_token =  new Lista_tokens();
    Tokens_L tokens_L;
    Errores error;
    int conteo_errores = 1;
    int conteo_tokens = 1;
%}

%init{
    yyline = 1;
    yycolumn = 1;
%init}

%%

program {System.out.println("Inicio: "+ yytext() +
    ", en la linea: "+yyline+", en la columna: "+yycolumn); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Program");
                            lista_token.agegarLista(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Program, yyline, yycolumn, yytext());}
end     {return new Symbol(sym.End, yyline, yycolumn, yytext());}
var     {return new Symbol(sym.Var, yyline, yycolumn, yytext());}
arr  {return new Symbol(sym.Arr, yyline, yycolumn, yytext());}
console    {return new Symbol(sym.Console, yyline, yycolumn, yytext());}
print     {return new Symbol(sym.Print, yyline, yycolumn, yytext());}
column     {return new Symbol(sym.Column, yyline, yycolumn, yytext());}
char     {return new Symbol(sym.Tipo_char, yyline, yycolumn, yytext());}
double     {return new Symbol(sym.Tipo_double, yyline, yycolumn, yytext());}
sum     {return new Symbol(sym.A_sum, yyline, yycolumn, yytext());}
res     {return new Symbol(sym.A_res, yyline, yycolumn, yytext());}
mul     {return new Symbol(sym.A_mul, yyline, yycolumn, yytext());}
div     {return new Symbol(sym.A_div, yyline, yycolumn, yytext());}
mod     {return new Symbol(sym.A_mod, yyline, yycolumn, yytext());}
min     {return new Symbol(sym.E_min, yyline, yycolumn, yytext());}
max     {return new Symbol(sym.E_max, yyline, yycolumn, yytext());}
media   {return new Symbol(sym.E_media, yyline, yycolumn, yytext());}
mediana {return new Symbol(sym.E_mediana, yyline, yycolumn, yytext());}
moda    {return new Symbol(sym.E_moda, yyline, yycolumn, yytext());}
varianza {return new Symbol(sym.E_varianza, yyline, yycolumn, yytext());}
graphpie {return new Symbol(sym.G_graphpie, yyline, yycolumn, yytext());}
titulo   {return new Symbol(sym.G_titulo, yyline, yycolumn, yytext());}
label  {return new Symbol(sym.G_label, yyline, yycolumn, yytext());}
grapPie    {return new Symbol(sym.G_grapPie, yyline, yycolumn, yytext());}
graphbar {return new Symbol(sym.G_graphbar, yyline, yycolumn, yytext());}
ejex    {return new Symbol(sym.G_ejex, yyline, yycolumn, yytext());}
ejey    {return new Symbol(sym.G_ejey, yyline, yycolumn, yytext());}
titulox {return new Symbol(sym.G_titulox, yyline, yycolumn, yytext());}
tituloy {return new Symbol(sym.G_tituloy, yyline, yycolumn, yytext());}
grapbar {return new Symbol(sym.G_grapbar, yyline, yycolumn, yytext());}
graphline   {return new Symbol(sym.G_graphline, yyline, yycolumn, yytext());}
grapline  {return new Symbol(sym.G_grapline, yyline, yycolumn, yytext());}
histogram {return new Symbol(sym.G_histogram, yyline, yycolumn, yytext());}
values {return new Symbol(sym.G_values, yyline, yycolumn, yytext());}
exec {return new Symbol(sym.G_exec, yyline, yycolumn, yytext());}
"=" {return new Symbol(sym.Igual, yyline, yycolumn, yytext());}
"+" {return new Symbol(sym.Suma, yyline, yycolumn, yytext());}
"," {return new Symbol(sym.Coma, yyline, yycolumn, yytext());}
"-" {return new Symbol(sym.Resta, yyline, yycolumn, yytext());}
"*" {return new Symbol(sym.Multiplicacion, yyline, yycolumn, yytext());}
"/" {return new Symbol(sym.Division, yyline, yycolumn, yytext());}
"(" {return new Symbol(sym.Parentesis_a, yyline, yycolumn, yytext());}
")" {return new Symbol(sym.Parentesis_c, yyline, yycolumn, yytext());}
"{" {return new Symbol(sym.Llave_a, yyline, yycolumn, yytext());}
"}" {return new Symbol(sym.Llave_c, yyline, yycolumn, yytext());}
":" {return new Symbol(sym.Dos_puntos, yyline, yycolumn, yytext());}
"<-" {return new Symbol(sym.Reserve, yyline, yycolumn, yytext());}
";" {return new Symbol(sym.P_coma, yyline, yycolumn, yytext());}
"[" {return new Symbol(sym.Parent_a, yyline, yycolumn, yytext());}
"]" {return new Symbol(sym.Parent_c, yyline, yycolumn, yytext());}
"." {return new Symbol(sym.Punto, yyline, yycolumn, yytext());}
"“" {return new Symbol(sym.C_dobles_a, yyline, yycolumn, yytext());}
"”" {return new Symbol(sym.C_dobles_c, yyline, yycolumn, yytext());}
"@" {return new Symbol(sym.Arroba, yyline, yycolumn, yytext());}
"::" {return new Symbol(sym.Doble_puntos, yyline, yycolumn, yytext());}
{L}({L}|{D})* {return new Symbol(sym.Identificador, yyline, yycolumn, yytext());}
{D}+("."{D}+)? {return new Symbol(sym.Numero, yyline, yycolumn, yytext());}

{espacio} {/*Ignore*/}

/* Comentarios */
( "!"(.)* ) {/*Ignore*/}

/* multi comentario */
"<!"([^!]|\n|!([^>]|[^>!]))*"!>" {/*Ignore*/}

. {System.out.println("Este es un error lexico: "+ yytext() +
    ", en la linea: "+yyline+", en la columna: "+yychar); return new Symbol(sym.ERROR, yyline, yycolumn, yytext());}
