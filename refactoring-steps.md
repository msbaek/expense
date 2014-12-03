## 1. Function Should Do One Thing
#### 1.1 penniesToDollars
- extract variable
- extract method
- inline variabel

#### 1.2 printXXX
- printHeader
- printTotals
- printExpenses
	- for-loop 분리
	- extract method - printExpenses
	- extract method - totalUpExpenses
		- extract fields - total, mealExpenses
		- initialize in c'tor
		- extract method - totalUpExpenses
		- change signature - remove total, mealExpenses from parameter list

#### 1.3 extract method - getName

#### 1.4 assign field - ReportPrinter printer
- printer가 여러 메소드에서 파라미터로 사용되고 있다
- change signature - remove parameter printer

#### 1.5 extract method - printExpensesAndTotals
- move line up(totalUpExpenses)

#### 1.6 extract method - printExpense from printExpensesAndTotals
- to remove {}

#### 1.7 extract method - isMeal, isOverage


#### 1.8 extract method addTotals from totalUpExpenses
- to remove {}

## 2. Featuer Envy

#### 2.1 move method - isMeal, isOverage to Expense
- feature envy


## 3. SRP 위반 해소

#### 3.1 rename ExpenseReport to ExpenseReporter

#### 3.2 extract delegate - ExpenseReport

- BL(totalUpExpenses, addToTotals, addExenses, expenses, total, mealExpenses) 추출

#### 3.3 safely delete unused methods

## 4. OCP 위반 해소
- replace type code with subclasses

#### 4.1 test 수정 - Expense가 아니라 서브 클래스 생성하도록
- 생성자에서 type 파라미터는 이름과 중복. change signature
- push members down - isMeal, isOverage, getName - keep abstract

#### 4.2 run with coverage로 안 사용되는 코드 타입별로 제거

#### 4.3 remove type : Expense.Type enum 제거