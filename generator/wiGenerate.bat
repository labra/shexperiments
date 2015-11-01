@echo off
set generator=c:\basura\wigenerator\wigenerator-0.0.1\bin\
echo Starting loop
for %%a in (10,20,30,40) do (
 @echo generating for %%a 
 %generator%/wigenerator -c %%a -y %%a -i %%a -o "wi%%a_%%a_%%a.ttl"
)

 
 

