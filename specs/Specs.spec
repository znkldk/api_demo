Specification Heading
=====================

This is an executable specification file. This file follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

To execute this specification, run
	gauge specs

##Scenario 1:
* Allow
* Click menu item "App"
* Click menu item "Action Bar"
* Click menu item "Action Bar Tabs"
* Does Toggle tab passive mode
* Make Toggle Tab Active
* Add New Tab
* Add New Tab
* Add New Tab
* Check Tabs count
* Remove Tab
* Check Tab Names
* Remove All Tabs
* Check Tabs count

##Scenario 2:
* Allow
* Click menu item "App"
* Click menu item "Activity"
* Click menu item "Custom Title"
* Check navigationbar texts "Left is best" "Right is always right"
* Check TextBoxs texts "Left is best" "Right is always right"
* Write left TextBox "new left"
* Click button "Change Left"
* Write right TextBox "new right"
* Click button "Change Right"
* Check navigationbar texts "new left" "new right"
* Check TextBoxs texts "new left" "new right"

##Scenario 3:
* Allow
* Click menu item "App"
* Click menu item "Alert Dialogs"
* Click button "OK Cancel dialog with a message"
* Check Ok Cancel Dialog Message

##Scenario 4:
* Allow
* Click menu item "App"
* Click menu item "Fragment"
* Click menu item "Context Menu"
* Long press Long Press Me Button
* Contex Menu Drop Down Elements Check

##Scenario 5:
* Allow
* Click menu item "App"
* Click menu item "Fragment"
* Click menu item "Hide and Show"
* Hide And Show Check TextBox rank "1" expected "true"
* Hide And Show Check TextBox rank "2" expected "true"
* Hide And Show Click "Hide" Button rank "2"
* Hide And Show Check Button Text "Show" rank "2"
* Hide And Show Check TextBox rank "1" expected "true"
* Hide And Show Check TextBox rank "2" expected "false"
* Hide And Show Click "Show" Button rank "2"
* Hide And Show Check TextBox rank "1" expected "true"
* Hide And Show Check TextBox rank "2" expected "true"
* Hide And Show Check Button Text "Hide" rank "2"

##Scenario 6:
* Allow
* Click menu item "App"
* Click menu item "Notification"
* Click menu item "IncomingMessage"
* Click button "Show Notification"
* Open Notifications
* Check notification Contex
* Check notification expand "true"
* Click App Notification Expend Btn
* Check notification expand "false"

##Scenario 7:
* Allow
* Click menu item "Views"
* Click menu item "Tabs"
* Click menu item "5. Scrollable"
* Scrool left until find Last Tab
* Scrolable Check Last Tab content
