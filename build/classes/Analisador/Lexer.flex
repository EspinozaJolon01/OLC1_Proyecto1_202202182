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
espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
%}
%%

{espacio} {/*Ignore*/}
"!"* {/*Ignore*/}
"<!"     {
            int commentDepth = 1;
            while(commentDepth > 0) {
                String text = yytext();
                int pos = text.indexOf("!>");
                if(pos != -1) {
                    yychar += pos + 2;
                    commentDepth--;
                } else {
                    yychar += yylength();
                    yytext();
                }
            }
        }

"!>"*    {/*Ignore single line comments*/}

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
"var" {lexeme=yytext(); return D_variable;}
"double" {lexeme=yytext(); return Tipo;}
"char[]" {lexeme=yytext(); return Tipo;}

"PROGRAM" {lexeme=yytext(); return Program;}
"END" {lexeme=yytext(); return End;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
 . {return ERROR;}
