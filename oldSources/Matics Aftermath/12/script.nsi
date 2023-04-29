!include LogicLib.nsh
!include WinMessages.nsh
!include FileFunc.nsh

SetCompressor /SOLID zlib
SilentInstall silent
RequestExecutionLevel user
ShowInstDetails hide
Unicode True
 
OutFile "Matics.exe"
Icon "icon.ico"
VIProductVersion 0.0.12.0
VIAddVersionKey ProductName "Matics"
VIAddVersionKey LegalCopyright "Copyright (c) 2016-2020 Fabian Berger"
VIAddVersionKey FileDescription "Educational program for specific usecases"
VIAddVersionKey FileVersion 0.0.12.0
VIAddVersionKey ProductVersion "0.0.12.0"
VIAddVersionKey InternalName "Matics"
VIAddVersionKey OriginalFilename "Matics.exe"
 
Section
  SetOverwrite off 

  CreateDirectory "$APPDATA\Matics"


  SetOutPath "$APPDATA\Matics\jre-14"
  File /r "jre-14\*"
 
  InitPluginsDir
  SetOutPath $APPDATA\Matics
  File "Matics.jar"
  SetOutPath $APPDATA\Matics
  ${GetParameters} $R0
  nsExec::Exec '"$APPDATA\Matics\jre-14\bin\java.exe" -jar $APPDATA\Matics\Matics.jar $R0'
SectionEnd