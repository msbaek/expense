개요
==

이 프로젝트는 Robert C. Martin의 Clean Coders Screen Cast 중 Episode 10. OCP(Open but
Closed Principle)에서 사용된 예제를 짧은 변경 단위로 커밋하여 어떻게 하나의 클래스가 SRP(Single
Responsibility Principle)을 준수하면서 Modification에는 닫혀 있고, Extension에만 열려있는지를 알게 해
준다.

문제
==

Function Shoud Do Onething 위반
===

![](<fig-01-function-should-do-onething.png>)


-  함수가 너무 크고, 
-  중복도 존재(*xx / 100*)
-  작은 메소드들로 추출(extract)할 필요가 있다. 
-  [Composed Method Pattern](http://c2.com/ppr/wiki/WikiPagesAboutRefactoring/ComposedMethod.html), [Extract till drop](http://www.cleancoders.com/codecast/clean-code-episode-3/show) 규칙에 따라 extract method를 수행

SRP 위반
===
![](<fig-02-srp.png>)

-   비즈니스 로직(비용 계산 로직)과 메시지/포맷팅 로직이 섞여 있다.
-   한가지가 아니라 여러가지 이유로 변경이 필요한 경우가 발생한다.

OCP 위반
===
![](<fig-03-ocp.png>)

-   비지니스 규칙을 확장하고자 한다면 이 모듈을 수정해야 한다.
-   메시지와 포맷팅을 변경하고자 한다면 이 모듈을 수정해야한다(위 그림에서 붉은 박스처럼 타입에 의존한 코드로 인해)


만일 새로운 식사 타입으로 LUNCH를 추가하는 경우 타입에 의존하는 코드로 인해 어려움을 겪게된다. 시스템 내의 모든 소스에서 expense type에 의존하는 모든 switch-case나 if-else 문장을 수정해야 할 것이다.

Feature Envy
===
![](<fig-04-feature-envy.png>)

- Expense의 type, amount 등을 이용하여 결정을 내리고 있다.
- 이런 로직은 Expense에 있어야 함.

Refactoring
==

다행히 테스트(명확한 문서로서 실행 가능한 요구사항 역할)는 존재하여 공격적으로 리팩토링을 할 수 있다.