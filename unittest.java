public class unittest {
	
	private calculator calculator;
	private double firstNumber;
	private double secondNumber;
	private double result;

	@Before
	public void initTest() {
		calculator = new calculator();
		firstNumber = 10;
		secondNumber = 0;
	}
	
	@After
	public void afterTest() {
		 calculator = null;
	}

	@Test
	public void testAddition() {
		result = calculator.addition(firstNumber, secondNumber);
		assertEquals(new Double(firstNumber), new Double(result));
	}

	private void assertEquals(Double double1, Double double2) {
    }

    @Test
	public void testSubtraction() {
		result = calculator.subtraction(firstNumber, secondNumber);
		assertEquals(new Double(firstNumber), new Double(result));
	}

	@Test
	public void testMultiplication() {
		result = calculator.multiplication(firstNumber, secondNumber);
		assertEquals(new Double(secondNumber), new Double(result));
	}


	@Test
	public void testDivide() {
		calculator calculator = new calculator();
		Assert.assertEquals(2, calculator.divide(6, 3));
	}

	@Test(expected = ArithmeticException.class)
	public void testDivideWillThrowExceptionWhenDivideOnZero() {
		calculator calculator = new calculator();
		calculator.divide(6, 0);
	}
	public static void main(String[] args) {

}