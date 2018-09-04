@echo off

echo Atualizando diretório de desenvolvimento
COPY C:\Users\KAI\JaspersoftWorkspace\MyReports\*.jasper "c:\Users\KAI\Google Drive\Fanap\Irrradiacao.Solar\iRRadiacaoV31\src\reports\."

echo Atualizando diretório de produção
COPY "c:\Users\KAI\Google Drive\Fanap\Irrradiacao.Solar\iRRadiacaoV31\src\reports\*.jasper" "c:\Users\KAI\Google Drive\Fanap\Irrradiacao.Solar\iRRadiacaoV31\."

COPY "c:\Users\KAI\Google Drive\Fanap\Irrradiacao.Solar\iRRadiacaoV31\src\reports\*.jasper" "C:\Transfer\."


echo pause