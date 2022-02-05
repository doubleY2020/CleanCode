# 전사 Coding Convention : 명명규칙, Java
> Java 명명규칙 총 33종

### 1. 파일명
- CamelCase
- Class명, Interface명과 동일

### 2. Package명
- 모두 소문자로
- `.*` 지양
    - bad example : java.awt.*
    - good example : java.awt.image

### 3. Class / Interface명
- CamelCase
- 31문자 이내
- 명사형
- Interface의 경우 I로 시작. ex.IFigureDrawer

### 4. Instance
- 첫글자 소문자
- 3 <= 길이 < 31

### 5. 상수
- 모두 영문 대문자, _로 구분
- MAX_EQUIPMENT_COUNT

### 6. 필드 / 매개변수
- 첫글자 소문자
- 3 <= 길이 < 31
- l(el)지양. 1(숫자)과 혼동되기 때문
- 약어 지양 

### 7. 메소드
- 첫글자 소문자
- 동사 + 명사
- boolean : 동사 + 형용사 (isResizable)
- 3 <= 길이 < 31
- 이벤트리스너 : 명사 + 동사(ing, p.p)
    - ex. mouseClicked()

### 8. 배열
- bad example : int[] values
- good example : int values[]

## 2. 의미 있는 이름

1. 의도를 분명히 밝혀라.
- 코드 맥락이 코드에 드러나게 작성하기
- 좋은 이름을 지으려면 시간이 걸리지만, 좋은 이름으로 절약하는 시간이 훨씬 더 많다.

2. 그릇된 정보를 피하라.
- 나름 널리 쓰이는 의미가 있는 단어를 다른 의미로 사용하지 X
- 실제 List가 아니면 List라고 쓰지 X
- 흡사한 이름 사용 X : 코드 자동완성시 혼란 야기

3. 의미 있게 구분하라. 
- 의미가 다르다면, 이름도 달라져야 한다. 
- bad case
```java
getActiveAccount();
getActiveAccounts();
getActiveAccountInfo();
```

4. 발음하기 쉬운 이름을 사용해라.
- 프로그래밍도 사회 활동이다.
- 발음하기 힘들면 리뷰 / 토론하기 힘들다.

5. 검색하기 쉬운 이름을 사용해라.

6. 인코딩을 피하라. 
- 헝가리안 표기법 지양

> 이름 앞에 데이터 타입을 명시하는 코딩 규칙

- 멤버 변수 접두어(m_) 지양

> m_dsc

- 인코딩이 필요한 경우 : 인터페이스 클래스와 구현 클래스
    - I 접두어 자제 (ex. IShapeFactory)
    - 구현 클래스에 인코딩. (ex. ShapeFactoryImp or CShapeFactory)
    
7. 자신의 기억력을 자랑하지 마라.

8. 클래스 이름
- 명사, 명사구
- Manager Processor, Data, Info 같은 단어는 피하라.
 
9. 메서드 이름
- 동사, 동사구

10. 기발한 이름은 피하라
- 재밌는 이름보다 명료한 이름을 선택하라.
- 속어 지양

11. 한 개념에 한 단어를 사용하라. (일관성 있는 어휘)
12. 코드를 읽을 사람도 프로그래머이. 프로그래밍 용어에서 가져온 이름을 선택하라.
12. 프로그래밍 용어가 없다면, 그 분야 언어에서 가져온 이름을 사용하라.