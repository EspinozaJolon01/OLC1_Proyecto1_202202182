/*
 * Desarrollado por José Luis Espinoza Jolón
 * jespinozajolon@gmail.com
 * Enero - 2024
 */
package Analisador;
import java_cup.runtime.Symbol;
import Clases.Errores;
import Clases.Tokens_L;
import java.util.ArrayList;
import java.util.List;

%%
%class LexerCup
%type java_cup.runtime.Symbol
%public
%line 
%char 
%cup
%unicode 
%ignorecase 
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ \t\r\n]+
ESPACIO=[ ]
NUMERO = {D}+("."{D}+)?

%{
    public static List<Errores> lista_E =  new ArrayList<>();
    public static List<Tokens_L> lista_T =  new ArrayList<>();

    
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

"program" {System.out.println("Inicio: "+ yytext() +
    ", en la linea: "+yyline+", en la columna: "+yycolumn); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Reservada",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Program, yyline, yycolumn, yytext());}
"end" {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Reservada",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.End, yyline, yycolumn, yytext());}
var {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Reservada",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Var, yyline, yycolumn, yytext());}
arr  {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Arreglo",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Arr, yyline, yycolumn, yytext());}
console    {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Imprimir",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Console, yyline, yycolumn, yytext());}
print     {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "imprimir",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Print, yyline, yycolumn, yytext());}
column     {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "column",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Column, yyline, yycolumn, yytext());}
char\[\]|double     {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Tipos",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Tipo, yyline, yycolumn, yytext());}

sum     {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Estadistico_S",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.OPA, yyline, yycolumn, yytext());}
res     {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Estadistico_R",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.OPA, yyline, yycolumn, yytext());}
mul     {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Estadistico_M",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.OPA, yyline, yycolumn, yytext());}
div     {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Estadistico_D",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.OPA, yyline, yycolumn, yytext());}
mod     {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Estadistico_mod",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.OPA, yyline, yycolumn, yytext());}
min     {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Estadistico_min",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.OPE, yyline, yycolumn, yytext());}
max     {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Estadistico_max",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.OPE, yyline, yycolumn, yytext());}
media   {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Estadistico_media",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.OPE, yyline, yycolumn, yytext());}
mediana {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Estadistico_mediana",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.OPE, yyline, yycolumn, yytext());}
moda    {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Estadistico_moda",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.OPE, yyline, yycolumn, yytext());}
varianza {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Estadistico_varianza",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.OPE, yyline, yycolumn, yytext());}
graphpie {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Estadistico_g",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.G_graphpie, yyline, yycolumn, yytext());}
titulo   {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "titulo",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.G_titulo, yyline, yycolumn, yytext());}
label  {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "label",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.G_label, yyline, yycolumn, yytext());}

graphbar {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "graBar",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.G_graphbar, yyline, yycolumn, yytext());}
ejex    {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Gejex",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.G_ejex, yyline, yycolumn, yytext());}
ejey    {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Gejey",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.G_ejey, yyline, yycolumn, yytext());}
titulox {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Gtitulox",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.G_titulox, yyline, yycolumn, yytext());}
tituloy {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Gtituiloy",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.G_tituloy, yyline, yycolumn, yytext());}

graphline   {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Gline",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.G_graphline, yyline, yycolumn, yytext());}

histogram {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Ghisto",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.G_histogram, yyline, yycolumn, yytext());}
values {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Gvalues",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.G_values, yyline, yycolumn, yytext());}
exec {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Gexec",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.G_exec, yyline, yycolumn, yytext());}
"=" {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "igual",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Igual, yyline, yycolumn, yytext());}
"+" {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "mas",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Suma, yyline, yycolumn, yytext());}
"," {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "coma",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Coma, yyline, yycolumn, yytext());}
"-" {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "menos",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Resta, yyline, yycolumn, yytext());}
"*" {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "multi",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Multiplicacion, yyline, yycolumn, yytext());}
"/" {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "div",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Division, yyline, yycolumn, yytext());}
"(" {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "ParentA",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Parentesis_a, yyline, yycolumn, yytext());}
")" {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "ParentC",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Parentesis_c, yyline, yycolumn, yytext());}
"{" {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "llaveA",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Llave_a, yyline, yycolumn, yytext());}
"}" {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "llaveC",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Llave_c, yyline, yycolumn, yytext());}
":" {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "dos_puntos",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Dos_puntos, yyline, yycolumn, yytext());}
"<-" {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Reserv",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Reserve, yyline, yycolumn, yytext());}
"->" {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Reserv",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Reservemenor, yyline, yycolumn, yytext());}
";" {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Punto_com",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.P_coma, yyline, yycolumn, yytext());}
"[" {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "ParentA",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Parent_a, yyline, yycolumn, yytext());}
"]" {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "ParentC",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Parent_c, yyline, yycolumn, yytext());}
"." {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Punto",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Punto, yyline, yycolumn, yytext());}
"“" {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "CDobles",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.C_dobles_a, yyline, yycolumn, yytext());}
"”" {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "CDobles",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.C_dobles_c, yyline, yycolumn, yytext());}
"@" {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Arroba",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Arroba, yyline, yycolumn, yytext());}
"::" {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Doble_puntos",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Doble_puntos, yyline, yycolumn, yytext());}
{L}({L}|{D})* {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "String",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Identificador, yyline, yycolumn, yytext());}
{NUMERO} {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "Numero",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Numero, yyline, yycolumn, yytext());}

"\“"({L}|{D}|{ESPACIO}|{NUMERO})*"\”"  {System.out.println("Encontrado "+ yytext()); tokens_L = new Tokens_L(conteo_tokens, yytext(), "cadena",yyline,yycolumn);
                            lista_T.add(tokens_L);
                            conteo_tokens++;
        return new Symbol(sym.Cadena, yyline, yycolumn, yytext());}

{espacio} {/*Ignore*/}

/* Comentarios */
( "!"(.)* ) {/*Ignore*/}

/* multi comentario */
"<!"([^!]|\n|!([^>]|[^>!]))*"!>" {/*Ignore*/}

. {System.out.println("Este es un error lexico: "+ yytext() +
    ", en la linea: "+yyline+", en la columna: "+yychar); return new Symbol(sym.ERROR, yyline, yycolumn, yytext());}
