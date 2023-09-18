package org.homework;


enum InputOption {
    INSERT("1"),    //1. 추가
    DELETE("2"),    //2. 삭제
    SELECT("3"),    //3. 조회
    SELECTALL("4"),  //4. 전체 할 일 목록 출력
    SELECTALLSORT("5"), //5. 정렬 조회
    COMPLETE("6"),  //6. 완료
    SEARCH("7"),    //7.검색
    EXIT("8"),       //8. 종료
    INVALID_INPUT("");


    private final String input;

    InputOption(String input) {
        this.input = input;
    }

    public static InputOption of(String input) {

        for (InputOption value : InputOption.values()) {
            if (value.input.equals(input)) {
                return value;
            }
        }
        return INVALID_INPUT;
    }

}

