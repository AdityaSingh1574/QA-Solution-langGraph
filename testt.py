from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys

# Initialize WebDriver (Make sure you have the right path to your ChromeDriver)
driver = webdriver.Chrome()

# Open Sauce Demo website
driver.get('https://www.saucedemo.com/')

# Log in to the website (As an example, since Sauce Demo requires login)
username = driver.find_element(By.ID, "user-name")
password = driver.find_element(By.ID, "password")
login_button = driver.find_element(By.ID, "login-button")

# Provide login credentials
username.send_keys("standard_user")
password.send_keys("secret_sauce")

# Click on login button
login_button.click()

# Navigate to a product page or perform some action
product = driver.find_element(By.CLASS_NAME, "inventory_item_name")
product.click()

# Verify the current URL
current_url = driver.current_url
expected_url = "https://www.saucedemo.com/inventory-item.html?id=4"  # Adjust based on the product

if expected_url in current_url:
    print("The URL is correct:", current_url)
else:
    print("The URL is incorrect, got:", current_url)

# Close the browser
driver.quit()
