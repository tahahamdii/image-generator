# OpenAI Spring Boot Backend

## Introduction

This is a Spring Boot backend application that integrates with OpenAI's APIs to provide AI-powered chat responses and image generation. The application exposes RESTful endpoints that you can call to interact with OpenAI's GPT models and DALL·E image generation.

## Prerequisites

- **Java 17** or later
- **Maven** or **Gradle** build tool
- An **OpenAI API Key**

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/tahahamdii/image-generator
cd openai
````
# OpenAI Spring Boot Backend

## Introduction

This is a Spring Boot backend application that integrates with OpenAI's APIs to provide AI-powered chat responses and image generation. The application exposes RESTful endpoints that you can call to interact with OpenAI's GPT models and DALL-E image generation.

## Prerequisites
### Set Up Your OpenAI API Key

You need to provide your OpenAI API key for the application to communicate with OpenAI's services.

#### Option 1: Using Environment Variables (Recommended)

Set an environment variable `OPENAI_API_KEY` with your OpenAI API key.

-   **On Linux or macOS:**

    bash


    `export OPENAI_API_KEY=your-openai-api-key`

-   **On Windows Command Prompt:**

    cmd


    `set OPENAI_API_KEY=your-openai-api-key`

-   **On Windows PowerShell:**

    powershell


    `$env:OPENAI_API_KEY="your-openai-api-key"`

#### Option 2: Using `application.properties` (Not Recommended for Production)

You can set the API key directly in the `src/main/resources/application.properties` file:

properties


`openai.api.key=your-openai-api-key`

**Note**: If you choose this option, make sure not to commit your `application.properties` file to version control to avoid exposing your API key.

### Build the Project

#### Using Maven

bash


`mvn clean install`

#### Using Gradle

bash


`./gradlew build`

### Run the Application

#### Using Maven

bash


`mvn spring-boot:run`

#### Using Gradle

bash


`./gradlew bootRun`

The application will start on `http://localhost:8080`.

API Endpoints
-------------

### 1\. Chat Endpoint

#### `GET /query`

Generates a chat response from the AI model based on the provided prompt.

**Query Parameters:**

-   `prompt` (required): The user's input prompt.

**Example Request:**

bash


`GET http://localhost:8080/query?prompt=Hello+world`

**Example Response:**

json


`"Hello! How can I assist you today?"`

### 2\. Chat with Custom Options Endpoint

#### `GET /query2`

Generates a chat response with customizable options such as model and temperature.

**Query Parameters:**

-   `prompt` (required): The user's input prompt.

**Example Request:**

bash


`GET http://localhost:8080/query2?prompt=Tell+me+a+joke`

**Example Response:**

json


`"Why don't scientists trust atoms? Because they make up everything!"`

**Note**: The `/query2` endpoint uses a custom service where you can change the AI model or the temperature (creativity level). Modify the `ChatService` class to adjust these settings.

### 3\. Image Generation Endpoint

#### `GET /generate-image`

Generates images based on the provided prompt using OpenAI's image generation API.

**Query Parameters:**

-   `prompt` (required): A text description of the desired image.
-   `quality` (optional): Image quality. Default is `hd`.
-   `n` (optional): Number of images to generate. Default is `1`.
-   `width` (optional): Width of the image in pixels. Default is `1024`.
-   `height` (optional): Height of the image in pixels. Default is `1024`.

**Example Request:**

bash


`GET http://localhost:8080/generate-image?prompt=A+sunset+over+the+mountains&n=2`

**Example Response:**

json


`[
  "https://openai.com/your-generated-image-url-1.png",
  "https://openai.com/your-generated-image-url-2.png"
]`

Customization
-------------

### Changing the Model or Temperature

The `/query2` endpoint allows you to customize the AI model and temperature settings.

To modify these settings:

1.  Open the `ChatService` class.
2.  Adjust the model name and temperature in the `getResponseOptions` method.

java


`public String getResponseOptions(String prompt) {
    // Set custom options here
    String modelName = "gpt-3.5-turbo"; // or "gpt-4" if you have access
    double temperature = 0.7; // Adjust between 0.0 and 1.0
    // Use these options in your API call
}`

**Note**: Make sure you have access to the specified model in your OpenAI account.

Project Structure
-----------------

-   **`Controller.java`**: Handles incoming HTTP requests and maps them to service methods.
-   **`ChatService.java`**: Contains logic for interacting with OpenAI's chat models.
-   **`ImageService.java`**: Contains logic for generating images using OpenAI's image models.
-   **`application.properties`**: Spring Boot configuration file.

Dependencies
------------

Ensure you have the following dependencies in your `pom.xml` (for Maven) or `build.gradle` (for Gradle):

-   Spring Boot Starter Web
-   Spring AI (e.g., `spring-ai-openai`)
-   Any other necessary Spring Boot dependencies

Important Notes
---------------

-   **API Key Security**: Keep your OpenAI API key secure. Do not expose it in public repositories or share it publicly.
-   **Comply with OpenAI Policies**: Ensure that you comply with OpenAI's [Usage Policies](https://platform.openai.com/docs/usage-policies) when using the API.
-   **Model Access**: Access to certain models like `gpt-4` may require special access or a paid subscription. Verify your access permissions in your OpenAI account.

Troubleshooting
---------------

-   **Model Not Found Error**: If you encounter an error stating that the model does not exist or you do not have access to it, double-check the model name and ensure you have access to it.
-   **API Key Issues**: If the application cannot authenticate with OpenAI, ensure your API key is correctly set and that there are no extra spaces or hidden characters.
-   **Dependencies**: Ensure all required dependencies are correctly added to your project and that the versions are compatible.



Contact
-------

For any questions or issues, please open an issue in the repository or contact me hamdi.taha@esprit.tn or you check my website https://tahtah.tech
