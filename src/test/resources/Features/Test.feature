Feature: Home page

  @Login
  Scenario: 
    Given A user navigates to HomePage "https://demo-savana.savanainc.com/nGageBanking/Login.aspx"
    Then I login using "Ubolisetty" "Demo@s123"
    Then submit the data
      | FormName       | FieldName        | Data  |
      | AccountCreate  | Account Nickname | TestNickName_auto  |
      | AccountCreate  | Account Title    | TestTitle_auto   |
      | AccountCreate  | Reference ID     | 1234   |

  
      