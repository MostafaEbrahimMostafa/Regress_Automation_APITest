# 🚀 Regress API Automation Testing Project

## 📖 Project Overview
The **Regress API Automation Testing Project** is designed to validate the functionalities of the **Reqres API** using **RestAssured and TestNG**. This project automates key API operations, including **user management, resource retrieval, authentication scenarios, and error handling**, ensuring reliability, efficiency, and robustness in API responses.

## 🎯 Project Objective
The primary objectives of this automation framework are to:
- ✅ **Ensure API reliability and functional correctness** by validating CRUD operations.
- ✅ **Enhance test coverage** across different scenarios, including edge cases and negative testing.
- ✅ **Optimize testing efforts** by reducing manual intervention and executing automated API tests efficiently.
- ✅ **Improve reporting and debugging** through **Allure Reports**, providing insightful execution logs and visualized test results.
- ✅ **Implement best practices** for maintainable and scalable API test automation.

## 🛠️ Technologies and Tools
This project is built using the following technologies and tools:

| Technology/Tool         | Purpose |
|------------------------|---------|
| **Java**              | Core programming language for automation scripts |
| **RestAssured**       | API testing framework for validating HTTP requests and responses |
| **TestNG**            | Test framework for managing test execution and reporting |
| **Allure Reports**    | Generates detailed test execution reports with logs and attachments |
| **Maven**             | Manages dependencies and builds the project efficiently |
| **JSON Assertions**   | Validates expected vs actual API responses |

## 📂 Project Structure
The project follows a well-organized folder structure to ensure scalability and maintainability:

```
RegressAPI/
│── src/
│   ├── main/
│   ├── test/
│   │   ├── java/
│   │   │   ├── Pojo/                        # POJO classes for data models
│   │   │   ├── Regress/                     # API test cases
│   │   │   │   ├── User Management classes
│   │   │   │   ├── Authentication Testing classes
│   │   │   │   ├── Resource Management classes
│   │   │   │   ├── Error Handling & Response Validation classes
│── resources/
│   ├── Valid_Login.json                     # JSON data for login test cases
│── allure-results/                          # Allure reports directory
│── pom.xml                                  # Maven Dependency Management file
|── README.md                                # Project documentation
```

## 🌟 Key Features

- **User Management**:
    - Create a new user.
    - Retrieve details of a user.
    - Update user information.
    - Delete a user.

- **Authentication Testing**:
    - Valid login scenario.
    - Invalid email login.
    - Invalid password login.
    - Successful user registration.
    - Invalid email/password registration.

- **Resource Management**:
    - Retrieve list of resources.
    - Retrieve details of a single resource.
    - Handle resource not found scenarios.

- **Error Handling & Response Validation**:
    - Test scenarios for delayed responses.
    - Validate response status codes, headers, and body content.
    - JSON schema validation for structured API responses.


## 🎥 Project Demo
Check out the full project demonstration video here:  
📺 **[Watch Demo](https://drive.google.com/file/d/1voxjf4shzsh0eZ-MkiZpLD6uFgyUDAds/view?usp=drive_link)**  

This project represents a **significant step in API test automation**, integrating **RestAssured and TestNG** to streamline API validation. Through the implementation of **best practices in API automation**, the project aims to:

- ✅ **Automate Reqres API functionalities**, including user and resource management operations.
- ✅ **Enhance API test execution efficiency** with structured test cases, reusable components, and assertions.
- ✅ **Provide insightful test reporting** with Allure Reports, ensuring clear visibility of test results and failures.
- ✅ **Ensure API stability and compliance** by handling different request/response scenarios and error cases.

🔹 I am excited about applying these skills to future projects to drive quality and efficiency! Let’s connect and exchange ideas about enhancing API testing practices.

## 📩 Contact
For any inquiries, collaborations, or contributions, feel free to reach out:

- **👤 Tester Name:** Mustafa Ibrahim Mostafa
- **📧 Email:** mustafa.ibrahim.qa@gmail.com
- **🔗 LinkedIn:** [MyProfile](https://www.linkedin.com/in/mostafa-ibrahim-mostafa/)
- **📞 Phone:** (+02) 01005747258

---
**📌 Note:** This project is actively maintained, and contributions are welcome! Feel free to fork the repository, raise issues, or submit pull requests to enhance the framework. 🚀

