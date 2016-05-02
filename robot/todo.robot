*** Settings ***
Library    Selenium2Library

*** Variables ***
${APP_PATH}    http://localhost:8887

*** Test Cases ***
Add New To-do Item, New Item Should Appear In List
    Open Browser    ${APP_PATH}
    Input Text    new-item-input    orange juice
    Click Button    add-new-item-btn
    Element Should Contain    to-do-list    orange juice
