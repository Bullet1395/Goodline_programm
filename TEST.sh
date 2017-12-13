TEST_OK=0
TEST_FAIL=0
TEST_COUNT=19
RESULT_TEST=0;

bash RUN.sh
RESULT_TEST=$?

if [[ $RESULT_TEST -eq 0 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
else
TEST_FAIL=$(( $TEST_FAIL+1 ))
fi
echo "Параметры тестирования: Нет параметров"
echo "Должен завершиться 0 = $RESULT_TEST"


bash RUN.sh -l User_Read -p 123_r
RESULT_TEST=$?
if [[ $RESULT_TEST -eq 0 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
else
TEST_FAIL=$(( $TEST_FAIL+1 ))
fi
echo "Параметры тестирования: -l User_Read -p 123_r"
echo "Должен завершиться 0 = $RESULT_TEST"


bash RUN.sh -l User_Write -p 123_w
RESULT_TEST=$?
if [[ $RESULT_TEST -eq 0 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Write -p 123_w"
echo "Должен завершиться 0 = $RESULT_TEST"


bash RUN.sh -l User_Execute -p 123_e
RESULT_TEST=$?
if [[ $RESULT_TEST -eq 0 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Execute -p 123_e"
echo "Должен завершиться 0 = $RESULT_TEST"


bash RUN.sh -l User -p 123_r
RESULT_TEST=$?
if [[ $RESULT_TEST -eq 1 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User -p 123_r"
echo "Должен завершиться 1 = $RESULT_TEST"


bash RUN.sh -l User_Read -p dsfadf
RESULT_TEST=$?
if [[ $RESULT_TEST -eq 2 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Read -p dsfadf"
echo "Должен завершиться 2 = $RESULT_TEST"


bash RUN.sh -l User_Read -p 123_r -r READ -path C.R.RR
RESULT_TEST=$?
if [[ $RESULT_TEST -eq 0 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Read -p 123_r -r READ -path C.R.RR"
echo "Должен завершиться 0 = $RESULT_TEST"


bash RUN.sh -l User_Read -p 123_r -r READ -path C.R.RR.RRR
RESULT_TEST=$?
if [[ $RESULT_TEST -eq 0 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Read -p 123_r -r READ -path C.R.RR.RRR"
echo "Должен завершиться 0 = $RESULT_TEST"


bash RUN.sh -l User_Write -p 123_w -r WRITE -path C.W.WR
RESULT_TEST=$?
if [[ $RESULT_TEST -eq 0 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Write -p 123_w -r WRITE -path C.W.WR"
echo "Должен завершиться 0 = $RESULT_TEST"


bash RUN.sh -l User_Write -p 123_w -r WRITE -path C.W.WR.R
RESULT_TEST=$?
if [[ $RESULT_TEST -eq 0 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Write -p 123_w -r WRITE -path C.W.WR.R"
echo "Должен завершиться 0 = $RESULT_TEST"


bash RUN.sh -l User_Write -p 123_w -r WRITE -path C.R.RR.W
RESULT_TEST=$?
if [[ $RESULT_TEST -eq 0 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Write -p 123_w -r WRITE -path C.R.RR.W"
echo "Должен завершиться 0 = $RESULT_TEST"


bash RUN.sh -l User_Read -p 123_r -r ALL -path C.R.RR
RESULT_TEST=$?
if [[ $RESULT_TEST -eq 3 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Read -p 123_r -r ALL -path C.R.RR"
echo "Должен завершиться 3 = $RESULT_TEST"


bash RUN.sh -l User_Read -p 123_r -r WRITE -path C.W
RESULT_TEST=$?
if [[ $RESULT_TEST -eq 4 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Read -p 123_r -r WRITE -path C.W"
echo "Должен завершиться 4 = $RESULT_TEST"


bash RUN.sh -l User_Execute -p 123_e -r READ -path C.R.RR
RESULT_TEST=$?
if [[ $RESULT_TEST -eq 4 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Execute -p 123_e -r READ -path C.R.RR"
echo "Должен завершиться 4 = $RESULT_TEST"


bash RUN.sh -l User_Read -p 123_r -r READ -path C.R.RR -ds 2017-10-11 -de 2017-10-11 -v 100
RESULT_TEST=$?
if [[ $RESULT_TEST -eq 0 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Read -p 123_r -r READ -path C.R.RR -ds 2017-10-11 -de 2017-10-11 -v 100"
echo "Должен завершиться 0 = $RESULT_TEST"


bash RUN.sh -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 2017-10-11 -de 2017-10-11 -v 100
RESULT_TEST=$?
if [[ $RESULT_TEST -eq 0 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 2017-10-11 -de 2017-10-11 -v 100"
echo "Должен завершиться 0 = $RESULT_TEST"


bash RUN.sh -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 2017-10-11 -de 2017-10-11 -v много
RESULT_TEST=$?
if [[ $RESULT_TEST -eq 5 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 2017-10-11 -de 2017-10-11 -v много"
echo "Должен завершиться 5 = $RESULT_TEST"


bash RUN.sh -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 101117 -de 101117 -v 100
RESULT_TEST=$?
if [[ $RESULT_TEST -eq 5 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 101117 -de 101117 -v 100"
echo "Должен завершиться 5 = $RESULT_TEST"



bash RUN.sh -l User_Read -p 123_r -r READ -path C.R.RR -ds 10.11.17 -de 10.11.17 -v 100
RESULT_TEST=$?
if [[ $RESULT_TEST -eq 5 ]]; then
TEST_OK=$(( $TEST_OK+1 ))
fi
echo "Параметры тестирования: -l User_Read -p 123_r -r READ -path C.R.RR -ds 10.11.17 -de 10.11.17 -v 100"
echo "Должен завершиться 5 = $RESULT_TEST"


echo "Завершенных успешно       - $TEST_OK"
echo "Заврешенных отрицательно  - $TEST_FAIL"
echo "Всего тестов              - $TEST_COUNT"

if [[ $TEST_OK -eq $TEST_COUNT ]]; then
exit 0
fi

if [[ $TEST_FAIL -gt 0 ]]; then
exit 1
fi
