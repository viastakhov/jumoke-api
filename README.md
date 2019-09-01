# Jumoke-API
API library for talking with [Jumoke Agents](https://github.com/viastakhov/jumoke-agent)

Jumoke is a framework for testing Desktop applications.
Jumoke supports following wellknown libraries:
* AutoIt X
* SikuliX
* WinAPI 

## Usage
* Run Jumoke Agent on remote machine;
* Type in your project following lines:
    ```java
    Agent agent = new Agent("<remote machine host>", 8080);
      
    // Autoit
    AutoIt au = agent.getAutoIt();
    String txt = au.controlGetText("[X:3; W:430]", "", "[CLASS:Button; INSTANCE:1]");    
    assert txt == "some text";
  
    // Sikuli X
    Sikuli sx = ag.getSikuli();
    Screen scr = sx.getScreen(0);
    Pattern ptn = new Pattern("<some image>.png");
    scr.click(ptn);
  
    // WinAPI
    final UINT Msg = new UINT(0x018B);
    final WPARAM wParam = new WPARAM(0);
    final LPARAM lParam = new LPARAM(0);  
    WinApi win = ag.getWinApi();
    int controlID = au.controlGetHandle("Title", "", "ListBox7");
    HWND hWnd = new HWND(Pointer.createConstant(controlID));
    int count = wn.sendMessage(hWnd, Msg, wParam, lParam).intValue();
    assert count == 5; 
    ```

## License  
Copyright © 2019 Vladimir Astakhov [viastakhov@mail.ru]

Distributed under the Eclipse Public License