package jumoke;


/**
 * Interface <b>IRegion</b></br>
 * All Known Implementing Classes: Region, Screen
 *
 * @author Astakhov Vladimir [VIAstakhov@mail.ru]
 * @version 1.1
 */
public interface IRegion {

    /**
     * Method <b>above</b> </br>
     * Returns a new Region that is defined with respect to the given region:
     * new bottom edge next pixel row above given region's top edge.</br><p>
     * It does not include the current region.
     *
     * @param range -  a positive integer defining the new dimension aspect (width or height).
     * If range is omitted, it reaches to the corresponding edge of the screen.
     * @return Returns a a new Region object.
     */
    //Region above(int range);
    //Region above();

    /**
     * Method <b>below</b> </br>
     * Returns a new Region that is defined with respect to the given region:
     * new top edge next pixel row below given region's bottom edge.</br><p>
     * It does not include the current region.
     *
     * @param range -  a positive integer defining the new dimension aspect (width or height).
     * If range is omitted, it reaches to the corresponding edge of the screen.
     * @return Returns a a new Region object.
     */
    //Region below(int range);
    //Region below();

    /**
     * Method <b>left</b> </br>
     * Returns a new Region that is defined with respect to the given region:
     * new right edge next pixel column left of given region's left edge.</br><p>
     * It does not include the current region.
     *
     * @param range -  a positive integer defining the new dimension aspect (width or height).
     * If range is omitted, it reaches to the corresponding edge of the screen.
     * @return Returns a a new Region object.
     */
    //Region left(int range);
    //Region left();

    /**
     * Method <b>right</b> </br>
     * Returns a new Region that is defined with respect to the given region:
     * new left edge next pixel column right of given region's right edge.</br><p>
     * It does not include the current region.
     *
     * @param range -  a positive integer defining the new dimension aspect (width or height).
     * If range is omitted, it reaches to the corresponding edge of the screen.
     * @return Returns a a new Region object.
     */
    //Region right(int range);
    //Region right();

    /**
     * Method <b>click(target[, modifiers])</b> </br>
     * Perform a mouse click on the click point using the left button.</br><p>
     *
     * @param target    - a pattern, a string, a match, a region or a location that evaluates to a click point.
     * @param modifiers - one or more key modifiers
     * @return Returns the number of performed clicks (actually 1). A 0 (integer null) means that because of
     * some reason, no click could be performed (in case of PS may be not Found).
     * @throws Exception
     */
    //<PSRML>int click(PSRML target, int modifiers);
    <PSRML> int click(PSRML target) throws Exception;

    /**
     * Method <b>doubleClick((target[, modifiers])</b> </br>
     * Perform a mouse double-click on the click point using the left button.</br><p>
     *
     * @param target - a pattern, a string, a match, a region or a location that evaluates to a click point.
     * @param modifiers - one or more key modifiers
     * @return Returns the number of performed double-clicks (actually 1). A 0 (integer null) means that because of
     * some reason, no click could be performed (in case of PS may be not Found).
     */
    //<PSRML>int doubleClick(PSRML target, int modifiers);
    //<PSRML>int doubleClick(PSRML target);

    /**
     * Method <b>exists(target[, seconds])</b> </br>
     * Check whether the give pattern is visible on the screen.</br><p>
     *
     * <b>Remarks </b></br>
     * <p>
     * Does exactly the same as Region.wait(), but no exception is raised in case of FindFailed. So it can be used to symplify
     * scripting in case that you only want to know wether something is there or not to decide how to proceed in your workflow.
     * So it is typically used with an if statement. At least one find operation is performed, even if 0 seconds is specified.
     * So specifying 0 seconds saves some time, in case there is no need to wait, since its your intention to get the information "not found" directly.
     *
     * @param target  - a Pattern object or a string (path to an image file or just plain text).
     * @param seconds - a number, which can have a fraction, as maximum waiting time in seconds. The internal granularity
     *                is milliseconds. If not specified, the auto wait timeout value set by Region.setAutoWaitTimeout() is used.
     *                Use the constant FOREVER to wait for an infinite time.
     * @return a boolean object that contains the best match. None is returned, if nothing is found within the specified waiting time.
     * @throws Exception
     */
    <PS> boolean exists(PS target, double seconds) throws Exception;

    /**
     * Method <b>paste([PSMRL, ]text)</b> </br>
     * Paste the text at a click point.</br><p>
     *
     * <b>Remarks </b> </br>
     * Pastes text using the clipboard (OS-level shortcut (Ctrl-V or Cmd-V)). So afterwards your clipboard contains text. paste() is a temporary solution for
     * typing international characters or typing on keyboard layouts other than US-QWERTY.
     * If PSMRL is given, a click on the clickpoint is performed before typing, to gain the focus. (Mac: it might be necessary, to use switchApp() to give focus
     * to a target application before, to accept typed/pasted characters.)
     * If PSMRL is omitted, it performs the paste on the current focused component (normally an input field).
     * <b>Side Effect</b> if PS was used, the match can be accessed using Region.getLastMatch() afterwards.
     * <b>Note</b>: Special keys (ENTER, TAB, BACKSPACE, ...) cannot be used with paste(). If needed, you have to split your complete text into two or more paste() and
     * use type() for typing the special keys inbetween. Characters like \n (enter/new line) and \t (tab) should work as expected with paste(), but be aware of
     * timing problems, when using e.g. intervening \t to jump to the next input field of a form.
     *
     * @param target - a pattern, a string, a match, a region or a location that evaluates to a click point.
     * @return the number 1 if the operation could be performed, otherwise 0 (integer null), which means, that because of some reason, it was not possible or the
     * click could be performed (in case of PS may be not Found).
     * @throws Exception
     */
    <PSRML> int paste(PSRML target, String text) throws Exception;

    /**
     * Method <b>rightClick((target[, modifiers])</b> </br>
     * Perform a mouse click on the click point using the right button..</br><p>
     *
     * @param target - a pattern, a string, a match, a region or a location that evaluates to a click point.
     * @param modifiers - one or more key modifiers
     * @return the number of performed right clicks (actually 1). A 0 (integer null) means that because of
     * some reason, no click could be performed (in case of PS may be not Found).
     */
    //<PSRML>int rightClick(PSRML target, int modifiers);
    //<PSRML>int rightClick(PSRML target);

    /**
     * Method <b>type([target, ]text[, modifiers])</b> </br>
     * Type the text at the current focused input field or at a click point specified by target.</br><p>
     *
     * <b>Remarks </b> </br>
     * This method simulates keyboard typing interpreting the characters of text based on the layout/keymap of the standard US keyboard (QWERTY).
     * Special keys (ENTER, TAB, BACKSPACE, ...) can be incorporated into text using the constants defined in Class Key using the standard string concatenation +.
     * If PSMRL is given, a click on the clickpoint is performed before typing, to gain the focus. (Mac: it might be necessary, to use switchApp() to give focus to a
     * target application before, to accept typed/pasted characters.)
     * If PSMRL is omitted, it performs the typing on the current focused visual component (normally an input field or an menu entry that can be selected by typing something).
     * <b>Side Effect</b> if PS was used, the match can be accessed using Region.getLastMatch() afterwards.
     * <b>Note</b>: If you need to type international characters or you are using layouts/keymaps other than US-QWERTY, you should use Region.paste() instead. Since type() is
     * rather slow because it simulates each key press, for longer text it is preferrable to use Region.paste().
     * <b>Best Practice</b>: As a general guideline, the best choice is to use paste() for readable text and type() for action keys like TAB, ENTER, ESC, .... Use one type()
     * for each key or key combination and be aware, that in some cases a short wait() after a type() might be necessary to give the target application some time to react and
     * be prepared for the next Sikuli action.
     *
     * @param target    - a pattern, a string, a match, a region or a location that evaluates to a click point.
     * @param modifiers - one or more key modifiers
     * @return the number 1 if the operation could be performed, otherwise 0 (integer null), which means, that because of some reason, it was not possible or the
     * click could be performed (in case of PS may be not Found).
     * @throws Exception
     */
    <PSRML> int type(PSRML target, String text) throws Exception;

    /**
     * Method <b>wait(target[, seconds])</b> </br>
     * Check whether the give pattern is visible on the screen.</br><p>
     *
     * <b>Remarks </b></br>
     * <p>
     * If PS is not specified, the script just pauses for the specified amount of time. It is still possible to use sleep(seconds) instead, but this is deprecated.
     * If PS is specified, it keeps searching the given pattern in the region until the image appears ( would have been found with Region.find()) or the specified
     * amount of time has elapsed. At least one find operation is performed, even if 0 seconds is specified.)
     *
     * @param target  - a Pattern object or a string (path to an image file or just plain text).
     * @param seconds - a number, which can have a fraction, as maximum waiting time in seconds. The internal granularity
     *                is milliseconds. If not specified, the auto wait timeout value set by Region.setAutoWaitTimeout() is used.
     *                Use the constant FOREVER to wait for an infinite time.
     * @return a boolean object that contains the best match or fails if not found.
     * @throws Exception
     */
    <PS> boolean wait(PS target, double seconds) throws Exception;
}
