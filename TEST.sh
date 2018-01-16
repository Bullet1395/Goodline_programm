TEST_OK=0
TEST_FAIL=0
TEST_COUNT=19
RESULT_TEST=0;

test() {
echo $1
./RUN.sh "$1"
RESULT_TEST=$?

if [[ "$RESULT_TEST" == "$2" ]]
        then
        echo "Тест завершен. Результаты: $2 = $RESULT_TEST"
        TEST_OK=$(( $TEST_OK+1 ))
else
    echo "Тест провален. Результаты: $2 = $RESULT_TEST"
    TEST_FAIL=$(( $TEST_FAIL+1 ))
fi
}

echo "Параметры тестирования: Нет параметров"
test "" 0

echo ""
echo "################################"
echo ""

echo "Параметры тестирования: -l User_Read -p 123_r"
test "-l User_Read -p 123_r" 0

echo ""
echo "################################"
echo ""

echo "Параметры тестирования: -l User_Write -p 123_w"
test "-l User_Write -p 123_w" 0

echo ""
echo "################################"
echo ""

echo "Параметры тестирования: -l User_Execute -p 123_e"
test "-l User_Execute -p 123_e" 0

echo ""
echo "################################"
echo ""

echo "Параметры тестирования: -l User -p 123_r"
test "-l User -p 123_r" 1

echo ""
echo "################################"
echo ""

echo "Параметры тестирования: -l User_Read -p dsfadf"
test "-l User_Read -p dsfadf" 2

echo ""
echo "################################"
echo ""

echo "Параметры тестирования: -l User_Read -p 123_r -r READ -path C.R.RR"
test "-l User_Read -p 123_r -r READ -path C.R.RR" 0

echo ""
echo "################################"
echo ""

echo "Параметры тестирования: -l User_Read -p 123_r -r READ -path C.R.RR.RRR"
test "-l User_Read -p 123_r -r READ -path C.R.RR.RRR" 0

echo ""
echo "################################"
echo ""

echo "Параметры тестирования: -l User_Write -p 123_w -r WRITE -path C.W.WR"
test "-l User_Write -p 123_w -r WRITE -path C.W.WR" 0

echo ""
echo "################################"
echo ""

echo "Параметры тестирования: -l User_Write -p 123_w -r WRITE -path C.W.WR.R"
test "-l User_Write -p 123_w -r WRITE -path C.W.WR.R" 0

echo ""
echo "################################"
echo ""

echo "Параметры тестирования: -l User_Write -p 123_w -r WRITE -path C.R.RR.W"
test "-l User_Write -p 123_w -r WRITE -path C.R.RR.W" 0

echo ""
echo "################################"
echo ""

echo "Параметры тестирования: -l User_Read -p 123_r -r ALL -path C.R.RR"
test "-l User_Read -p 123_r -r ALL -path C.R.RR" 3

echo ""
echo "################################"
echo ""

echo "Параметры тестирования: -l User_Read -p 123_r -r WRITE -path C.W"
test "-l User_Read -p 123_r -r WRITE -path C.W" 4

echo ""
echo "################################"
echo ""

echo "Параметры тестирования: -l User_Execute -p 123_e -r READ -path C.R.RR"
test "-l User_Execute -p 123_e -r READ -path C.R.RR" 4

echo ""
echo "################################"
echo ""

echo "Параметры тестирования: -l User_Read -p 123_r -r READ -path C.R.RR -ds 2017-10-11 -de 2017-10-11 -v 100"
test "-l User_Read -p 123_r -r READ -path C.R.RR -ds 2017-10-11 -de 2017-10-11 -v 100" 0

echo ""
echo "################################"
echo ""

echo "Параметры тестирования: -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 2017-10-11 -de 2017-10-11 -v 100"
test "-l User_Write -p 123_w -r WRITE -path C.W.WR -ds 2017-10-11 -de 2017-10-11 -v 100" 0

echo ""
echo "################################"
echo ""

echo "Параметры тестирования: -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 2017-10-11 -de 2017-10-11 -v много"
test "-l User_Write -p 123_w -r WRITE -path C.W.WR -ds 2017-10-11 -de 2017-10-11 -v много" 5

echo ""
echo "################################"
echo ""

echo "Параметры тестирования: -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 101117 -de 101117 -v 100"
test "-l User_Write -p 123_w -r WRITE -path C.W.WR -ds 101117 -de 101117 -v 100" 5

echo ""
echo "################################"
echo ""

echo "Параметры тестирования: -l User_Read -p 123_r -r READ -path C.R.RR -ds 10.11.17 -de 10.11.17 -v 100"
test "-l User_Read -p 123_r -r READ -path C.R.RR -ds 10.11.17 -de 10.11.17 -v 100" 5

echo ""
echo "################################"
echo ""

echo "Завершенных успешно       - $TEST_OK"
echo "Заврешенных отрицательно  - $TEST_FAIL"
echo "Всего тестов              - $TEST_COUNT"


if [[ $TEST_OK -eq $TEST_COUNT ]]; then
exit 0
fi

if [[ $TEST_FAIL -gt 0 ]]; then
exit 1
fi
