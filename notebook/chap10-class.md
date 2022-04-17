# Class
> by Jeff Langr

깨끗한 코드를 얻기 위해선 포맷/함수 그리고 더 높은 단계인 클래스를 깨끗하게 정의해야 한다. 



## 클래스 체계 
클래스를 정의하는 표준 자바 관례 -> 신문 기사처럼 읽혀야 한다. 
```java 
public class RedFlowerCounter(){
  static public String COLOR = "red";
  static private String SPECIES = "Tulipa";
  // public int count = 5; -> 정의하지 않는다. 
  private List<Flower> flowers = new ArrayList();

  public List<Flower> getFlowers(){
    return filter(flowers);
  }
  
  private List<Flower> fliter(List<Flower> flowers){
    return flowers.stream().filter( f -> f.getColor().eqauls(COLOR) ).collect(Collectors.toList());
  }
  ... 
}
```

### 캡슐화 
- 변수와 유틸리티 함수는 가능한 공개하지 않는 편이 낫다. 
  - 때로는 테스트 코드에 접근을 허용하기도 하지만, 이때도 protect나 default로 최대한 제어한다. 

## 클래스는 작아야 한다. 
- 클래스의 책임은 최소화해야 한다. 
- 클래스 이름은 해당 클래스 책임을 기술해야 하는데, 이는 클래스 크기를 줄이는 첫번째 관문이다. 

### 단일 책임 원칙(Single Responsibility Principle, SRP)
- 클래스나 모듈을 변경할 이유가 단 하나뿐이어야 한다는 원칙. -> 클래스는 단 한 개의 책임을 가져야 한다.
- 책임을 정의하다 보면 코드를 추상화하기 쉬워진다. 
- 큰 클래스 몇 개가 아니라 작은 클래스 여럿으로 이뤄진 시스템이 더 바람직하다. 

### 응집도(Cohension)  
- 내부 처리 요소들이 서로 관련되어 있는 정도. 
- 응집도가 높다 => 클래스에 속한 메서드와 변수가 서로 의존하며 논리적인 단위로 묶인다. 

### 응집도를 유지하면 작은 클래스 여럿이 나온다. 
- 클래스가 응집력을 잃는다면 쪼개라. 
- 큰 하나의 클래스를 여러 클래스로 분리했을 경우, 코드의 길이가 다음과 같은 이유로 늘어난다. 
  1. 서술적인 변수 이름을 사용한다. 
  2. 함수 선언과 클래스 선언으로 주석을 대신했다. 
  3. 가독성을 높이기 위해 공백을 추가하고 형식을 맞췄다. (code formatting) 

## 변경하기 쉬운 클래스 
- SRP과 OCP(Open-Closed Principle, 개방 폐쇄 원칙)를 지원함. 
  - OCP : 클래스 확장에 개방적이고, 수정에 폐쇄적. 
- 기능 수정 시 컨드릴 코드가 최소인 시스템 구조가 바람직하다. 

### 변경으로부터 격리 
- 요구사항은 변한다 !!! 
- 그러므로, **인터페이스**와 **추상 클래스**를 사용해 구현이 미치는 영향을 격리시킨다. => 시스템 **결합도**를 낮춤 
- 결합도를 낮추면 유연성과 재사용성이 높아지고, 시스템 요소들을 이해하기 더 쉬워진다. 
- 궁극적으로 DIP(Dependency Inversion Principle, 의존 역전 원칙)를 따르는 클래스가 된다. 
  - DIP : 추상화된 것은 구체적인 것에 의존하면 안된다. 











