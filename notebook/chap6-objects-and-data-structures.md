## 6. 객체와 자료 구조

### 6.1 자료 추상화
- 구현을 외부로 노출한 클래스 (자료구조)
```java
public class Point {
    public double x;
    public double y;
}
```


- 추상적인, 구현을 완전히 숨김 (객체)
```java
public interface Point2 {
    double getX();
    double getY();
    void setCartesian(double x, double y);
    double getR();
    double getTheta();
    void setPolar(double r, double theta);
}
```


- 구현을 감추려면 추상화가 필요하다. 
- 진정한 의미의 클래스 : 추상 인터페이스를 제공해 사용자가 구현을 모른 채 자료의 핵심을 조작할 수 있다. 
- 자료를 세세하게 공개하기보다는 추상적인 개념으로 표현하는 편이 좋다. 
- 아무 생각 없이 getter/setter 함수를 추가하는게 가장 나쁘다. 

### 6.2 자료/객체 비대칭
객체와 자료구조는 근본적으로 양분된다.
- 객체 : 추상화 뒤로 자료를 숨긴채 자료를 다루는 함수만 공개
- 자료구조 : 자료 그대로 공개, 함수 제공 X


> 절차적인 코드는 기존 자료구조를 변경하지 않으면서 새 함수를 추가하기 쉽다.

> 객체 지향 코드는 기존함수를 변경하지 않으면서 새 클래스를 추가하기 쉽다.

> 절차적인 코드는 새로운 자료구조를 추가하기 어렵다. 그러려면 모든 함수를 고쳐야 한다.

> 객체 지향 코드는 새로운 함수를 추가하기 어렵다. 그러려면 모든 클래스를 고쳐야 한다.

객체지향 코드에서 어려운 변경은 절차적인 코드에서 쉬우며, 

절차적인 코드에서 어려운 변경은 객체 지향 코드에서 쉽다.


### 6.3 디미터 법칙
- 디미터 법칙 : 모듈은 자신이 조작하는 객체의 속사정을 몰라야 한다. 즉, 객체는 조회함수로 내부 구조를 공개하면 안 된다.
- 기차 충돌 : 객차가 한줄로 이어진 기차처럼 보임. 일반적으로 조잡하다 여겨지는 방식이기 때문에 피하는 것이 좋음
```java
 // bad case, train wreck
 final String outputDir = ctxt.getOptions().getScratchDir().getAbsolutePath();

 // good case, 이렇게 나누는것이 좋음
 Options opts = ctxt.getOptions();
 File scratchDir = opts.getScratchDir();
 final String outputDir = scratchDir.getAbsolutePath();
```

- 잡종 구조 : 절반은 객체, 절반은 자료구조인 잡종 구조.
    - 프로그래머가 함수나 타입을 보호할지 공개할지 확신하지 못해 만든 설계에 불과
    - 피하는것이 좋다.
    

### 6.4 자료 전달 객체(DTO, Data Transfer Object)
- 자료 구조체의 전형적인 형태는 공개 변수만 있고 함수가 없는 클래스다
- 데이터베이스와 통신하거나 소켓에서 받은 메시지의 구문을 분석할때 유용.
- 일반적인 형태 : bean 구조.
- 활성 레코드 : DTO의 특수한 형태
    - 공개 변수가 있거나 비공개 변수에 getter/setter 가 있는 자료 구조지만, save()나 find() 같은 탐색 함수도 제공

### 결론
- 객체 : 동작을 공개하고 자료를 숨긴다.
    - 기존 동작을 변경하지 않으면서 새 객체 타입을 추가하기는 쉽다.
    - 기존 객체에 새 동작을 추가하기 어렵다.
- 자료 구조 : 별다른 동작 없이 자료를 노출한다.
    - 기존 자료구조에 새 동작을 추가하기 쉽다.
    - 기존 함수에 새 자료구조를 추가하기 어렵다.