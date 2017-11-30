TEST_OK=0
TEST_FAIL=0
TEST_COUNT=19

bash RUN.sh
if [[ $? -eq 0 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
else
TEST_FAIL=$(( $TEST_FAIL+1 ))
fi
echo "Параметры тестирования: Нет параметров"
echo "Должен завершиться 0 = $?"


bash RUN.sh -l User_Read -p 123_r
if [[ $? -eq 0 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
else
TEST_FAIL=$(( $TEST_FAIL+1 ))
fi
echo "Параметры тестирования: -l User_Read -p 123_r"
echo "Должен завершиться 0 = $?"


bash RUN.sh -l User_Write -p 123_w
if [[ $? -eq 0 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Write -p 123_w"
echo "Должен завершиться 0 = $?"


bash RUN.sh -l User_Execute -p 123_e
if [[ $? -eq 0 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Execute -p 123_e"
echo "Должен завершиться 0 = $?"


bash RUN.sh -l User -p 123_r
if [[ $? -eq 1 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User -p 123_r"
echo "Должен завершиться 1 = $?"


bash RUN.sh -l User_Read -p dsfadf
if [[ $? -eq 2 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Read -p dsfadf"
echo "Должен завершиться 2 = $?"


bash RUN.sh -l User_Read -p 123_r -r READ -path C.R.RR
if [[ $? -eq 0 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Read -p 123_r -r READ -path C.R.RR"
echo "Должен завершиться 0 = $?"


bash RUN.sh -l User_Read -p 123_r -r READ -path C.R.RR.RRR
if [[ $? -eq 0 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Read -p 123_r -r READ -path C.R.RR.RRR"
echo "Должен завершиться 0 = $?"


bash RUN.sh -l User_Write -p 123_w -r WRITE -path C.W.WR
if [[ $? -eq 0 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Write -p 123_w -r WRITE -path C.W.WR"
echo "Должен завершиться 0 = $?"


bash RUN.sh -l User_Write -p 123_w -r WRITE -path C.W.WR.R
if [[ $? -eq 0 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Write -p 123_w -r WRITE -path C.W.WR.R"
echo "Должен завершиться 0 = $?"


bash RUN.sh -l User_Write -p 123_w -r WRITE -path C.R.RR.W
if [[ $? -eq 0 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Write -p 123_w -r WRITE -path C.R.RR.W"
echo "Должен завершиться 0 = $?"


bash RUN.sh -l User_Read -p 123_r -r ALL -path C.R.RR
if [[ $? -eq 3 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Read -p 123_r -r ALL -path C.R.RR"
echo "Должен завершиться 3 = $?"


bash RUN.sh -l User_Read -p 123_r -r WRITE -path C.W
if [[ $? -eq 4 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Read -p 123_r -r WRITE -path C.W"
echo "Должен завершиться 4 = $?"


bash RUN.sh -l User_Execute -p 123_e -r READ -path C.R.RR
if [[ $? -eq 4 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Execute -p 123_e -r READ -path C.R.RR"
echo "Должен завершиться 4 = $?"


bash RUN.sh -l User_Read -p 123_r -r READ -path C.R.RR -ds 2017-10-11 -de 2017-10-11 -v 100
if [[ $? -eq 0 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Read -p 123_r -r READ -path C.R.RR -ds 2017-10-11 -de 2017-10-11 -v 100"
echo "Должен завершиться 0 = $?"


bash RUN.sh -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 2017-10-11 -de 2017-10-11 -v 100
if [[ $? -eq 0 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 2017-10-11 -de 2017-10-11 -v 100"
echo "Должен завершиться 0 = $?"


bash RUN.sh -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 2017-10-11 -de 2017-10-11 -v много
if [[ $? -eq 5 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 2017-10-11 -de 2017-10-11 -v много"
echo "Должен завершиться 5 = $?"


bash RUN.sh -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 101117 -de 101117 -v 100
if [[ $? -eq 5 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 101117 -de 101117 -v 100"
echo "Должен завершиться 5 = $?"


bash RUN.sh -l User_Read -p 123_r -r READ -path C.R.RR -ds 10.11.17 -de 10.11.17 -v 100
if [[ $? -eq 5 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Read -p 123_r -r READ -path C.R.RR -ds 10.11.17 -de 10.11.17 -v 100"
echo "Должен завершиться 5 = $?"


echo $TEST_OK
echo $TEST_FAIL
echo $TEST_COUNT

if [[ $TEST_OK -eq $TEST_COUNT ]]; then
exit 0
fi

if [[ $TEST_FAIL -gt 0 ]]; then
exit 1
fi
