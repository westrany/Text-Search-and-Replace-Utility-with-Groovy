@echo off
set JAVAFX_SDK=C:\javafx-sdk1.3
groovy --module-path "%JAVAFX_SDK%\lib" --add-modules javafx.controls TextReplacerUI.groovy
