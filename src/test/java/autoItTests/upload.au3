WinActivate("Open")
WinWaitActive("Open")
ControlSend("Open", "", "Edit1", ".gitconfig")
ControlClick("Open", "&Open", "Button1")