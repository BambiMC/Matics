!include LogicLib.nsh
!include WinMessages.nsh
!include FileFunc.nsh
 
SilentInstall silent
RequestExecutionLevel user
ShowInstDetails hide
 
OutFile "Matics.exe"
Icon "icon.ico"
VIProductVersion 0.0.11.0
VIAddVersionKey ProductName "Matics"
VIAddVersionKey LegalCopyright "Copyright (c) 2016-2020 Fabian Berger"
VIAddVersionKey FileDescription "Educational program for specific usecases"
VIAddVersionKey FileVersion 0.0.11.0
VIAddVersionKey ProductVersion "0.0.11.0"
VIAddVersionKey InternalName "Matics"
VIAddVersionKey OriginalFilename "Matics.exe"
 
Section
  SetOverwrite off
 
  SetOutPath "$TEMP\jre-14"
  File /r "jre-14\*"
 
  InitPluginsDir
  SetOutPath $PluginsDir
  File "OUTPUT.jar"
  SetOutPath $TEMP
  ${GetParameters} $R0
  nsExec::Exec '"$TEMP\jre-14\bin\java.exe" -jar $PluginsDir\OUTPUT.jar $R0'
  RMDir /r $PluginsDir
SectionEnd