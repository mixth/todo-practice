*** Settings ***
Library    Selenium2Library

*** Test Cases ***
Search Facebook
    Open Browser    https://google.com    browser=chrome
    Input Text    lst-ib    Facebook
    Click Button    btnG
    Wait Until Page Contains    Facebook
