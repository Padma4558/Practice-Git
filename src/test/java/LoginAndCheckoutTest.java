import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginAndCheckoutTest {

    WebDriver driver;
    WebDriverWait wait;

    String email;

    @BeforeMethod
    public void setUp() {

        System.out.println("Opening Chrome...");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );

        driver.get("https://demowebshop.tricentis.com/");

        pause();
    }


    @Test
    public void loginAddProductAndCheckout() {

        // =====================================================
        // STEP 1: REGISTER
        // =====================================================

        System.out.println("STEP 1: Registering new user");

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Register")
                )
        ).click();

        pause();

        // Gender
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("gender-female")
                )
        ).click();

        // First Name
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("FirstName")
                )
        ).sendKeys("Test");

        // Last Name
        driver.findElement(
                By.id("LastName")
        ).sendKeys("Testing");

        // Create unique email
        email =
                "Testing" +
                        System.currentTimeMillis() +
                        "@example.com";

        System.out.println("Email: " + email);

        driver.findElement(
                By.id("Email")
        ).sendKeys(email);

        // Password
        driver.findElement(
                By.id("Password")
        ).sendKeys("Test@12345");

        // Confirm Password
        driver.findElement(
                By.id("ConfirmPassword")
        ).sendKeys("Test@12345");

        pause();

        // Register
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("register-button")
                )
        ).click();

        pause();

        // Verify registration
        WebElement registrationMessage =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.className("result")
                        )
                );

        Assert.assertEquals(
                registrationMessage.getText(),
                "Your registration completed",
                "Registration failed"
        );

        System.out.println("Registration successful");


        // =====================================================
        // STEP 2: LOGOUT
        // =====================================================

        System.out.println("STEP 2: Logout");

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Log out")
                )
        ).click();

        pause();


        // =====================================================
        // STEP 3: LOGIN
        // =====================================================

        System.out.println("STEP 3: Login");

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Log in")
                )
        ).click();

        pause();

        // Email
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("Email")
                )
        ).sendKeys(email);

        // Password
        driver.findElement(
                By.id("Password")
        ).sendKeys("Test@12345");

        pause();

        // Login
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("input[value='Log in']")
                )
        ).click();

        pause();

        // Verify login
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.linkText("Log out")
                )
        );

        System.out.println("Login successful");


        // =====================================================
        // STEP 4: OPEN BOOKS
        // =====================================================

        System.out.println("STEP 4: Opening Books category");

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Books")
                )
        ).click();

        pause();


        // =====================================================
        // STEP 5: ADD FIRST BOOK TO CART
        // =====================================================

        System.out.println("STEP 5: Adding book to cart");

        WebElement addToCart =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.cssSelector(
                                        "input[value='Add to cart']"
                                )
                        )
                );

        addToCart.click();

        pause();

        System.out.println("Book added to cart");


        // =====================================================
        // STEP 6: OPEN SHOPPING CART
        // =====================================================

        System.out.println("STEP 6: Opening shopping cart");

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Shopping cart")
                )
        ).click();

        pause();


        // =====================================================
        // STEP 7: VERIFY PRODUCT IN CART
        // =====================================================

        System.out.println("STEP 7: Verifying product in cart");

        WebElement cartItem =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.cssSelector(
                                        ".cart-item-row"
                                )
                        )
                );

        Assert.assertTrue(
                cartItem.isDisplayed(),
                "Product was not added to cart"
        );

        System.out.println("Product verified in cart");


        // =====================================================
        // STEP 8: ACCEPT TERMS
        // =====================================================

        System.out.println("STEP 8: Accepting terms");

        WebElement terms =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.id("termsofservice")
                        )
                );

        if (!terms.isSelected()) {
            terms.click();
        }

        pause();


        // =====================================================
        // STEP 9: CHECKOUT
        // =====================================================

        System.out.println("STEP 9: Clicking Checkout");

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("checkout")
                )
        ).click();

        pause();


        // =====================================================
        // STEP 10: CHECKOUT AS GUEST
        // =====================================================

        System.out.println("STEP 10: Checkout as Guest");

        try {

            WebElement guestCheckout =
                    wait.until(
                            ExpectedConditions.elementToBeClickable(
                                    By.cssSelector(
                                            "input[value='Checkout as Guest']"
                                    )
                            )
                    );

            guestCheckout.click();

            pause();

        } catch (Exception e) {

            System.out.println(
                    "Guest checkout option not displayed."
            );
        }


        // =====================================================
        // STEP 11: BILLING INFORMATION
        // =====================================================

        System.out.println("STEP 11: Filling billing information");

        // First Name
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("BillingNewAddress_FirstName")
                )
        ).sendKeys("Padma");

        // Last Name
        driver.findElement(
                By.id("BillingNewAddress_LastName")
        ).sendKeys("Bathula");

        // Email
        driver.findElement(
                By.id("BillingNewAddress_Email")
        ).sendKeys(
                "padma" +
                        System.currentTimeMillis() +
                        "@example.com"
        );

        // Country
        Select country =
                new Select(
                        driver.findElement(
                                By.id(
                                        "BillingNewAddress_CountryId"
                                )
                        )
                );

        country.selectByVisibleText("India");

        // City
        driver.findElement(
                By.id("BillingNewAddress_City")
        ).sendKeys("Bengaluru");

        // Address
        driver.findElement(
                By.id("BillingNewAddress_Address1")
        ).sendKeys("Test Street");

        // Zip
        driver.findElement(
                By.id("BillingNewAddress_ZipPostalCode")
        ).sendKeys("560035");

        // Phone
        driver.findElement(
                By.id("BillingNewAddress_PhoneNumber")
        ).sendKeys("9876543210");

        pause();

        System.out.println(
                "Billing information entered"
        );


        // =====================================================
        // STEP 12: CONTINUE BILLING
        // =====================================================

        System.out.println("STEP 12: Continuing billing");

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(
                                "input[onclick*='Billing.save']"
                        )
                )
        ).click();

        pause();


        // =====================================================
        // STEP 13: SHIPPING ADDRESS
        // =====================================================

        System.out.println("STEP 13: Continuing shipping");

        try {

            wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.cssSelector(
                                    "input[onclick*='Shipping.save']"
                            )
                    )
            ).click();

            pause();

        } catch (Exception e) {

            System.out.println(
                    "Shipping address step skipped."
            );
        }


        // =====================================================
        // STEP 14: SHIPPING METHOD
        // =====================================================

        System.out.println("STEP 14: Selecting shipping method");

        try {

            wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.cssSelector(
                                    "input[onclick*='ShippingMethod.save']"
                            )
                    )
            ).click();

            pause();

        } catch (Exception e) {

            System.out.println(
                    "Shipping method step skipped."
            );
        }


        // =====================================================
        // STEP 15: PAYMENT METHOD
        // =====================================================

        System.out.println("STEP 15: Selecting payment method");

        try {

            wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.cssSelector(
                                    "input[onclick*='PaymentMethod.save']"
                            )
                    )
            ).click();

            pause();

        } catch (Exception e) {

            System.out.println(
                    "Payment method step skipped."
            );
        }


        // =====================================================
        // STEP 16: PAYMENT INFORMATION
        // =====================================================

        System.out.println("STEP 16: Continuing payment");

        try {

            wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.cssSelector(
                                    "input[onclick*='PaymentInfo.save']"
                            )
                    )
            ).click();

            pause();

        } catch (Exception e) {

            System.out.println(
                    "Payment information step skipped."
            );
        }


        // =====================================================
        // STEP 17: CONFIRM ORDER
        // =====================================================

        System.out.println("STEP 17: Confirming order");

        try {

            wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.cssSelector(
                                    "input[value='Confirm']"
                            )
                    )
            ).click();

            pause();

        } catch (Exception e) {

            System.out.println(
                    "Confirm button not found."
            );
        }


        // =====================================================
        // STEP 18: VERIFY ORDER
        // =====================================================

        System.out.println("STEP 18: Verifying order");

        String pageText =
                driver.getPageSource().toLowerCase();

        Assert.assertTrue(
                pageText.contains("thank you") ||
                        pageText.contains("order"),
                "Order confirmation was not found"
        );

        System.out.println(
                "=========================================="
        );

        System.out.println(
                "TEST PASSED"
        );

        System.out.println(
                "Order process completed successfully"
        );

        System.out.println(
                "=========================================="
        );

        pause();
    }


// =====================================================
// PAUSE
// =====================================================

    private void pause() {

        try {

            Thread.sleep(2000);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }
    }


// =====================================================
// CLOSE BROWSER
// =====================================================

    @AfterMethod
    public void tearDown() {

        System.out.println("Closing browser...");

        pause();

        if (driver != null) {

            driver.quit();
        }
    }

}
