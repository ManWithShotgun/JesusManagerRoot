@echo off
for /l %%i in ( 0, 1, 9 ) do (
    set /a arr.%%i=%%i
	timeout 1 > NUL
	echo %%i
)