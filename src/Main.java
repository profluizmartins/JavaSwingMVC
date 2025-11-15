//TIP Para <b>executar</b> o código, pressione <shortcut actionId="Run"/> ou
// clique no ícone <icon src="AllIcons.Actions.Execute"/> no gutter.
void main() {
    //TIP Pressione <shortcut actionId="ShowIntentionActions"/> com seu caret no texto destacado
    // para ver como IntelliJ IDEA sugere corrigi-lo.
    IO.println(String.format("Hello and welcome!"));

    for (int i = 1; i <= 5; i++) {
        //TIP Pressione <shortcut actionId="Debug"/> para iniciar a depuração do seu código. Definimos um ponto de interrupção <icon src="AllIcons.Debugger.Db_set_breakpoint"/>
        // para você, mas você sempre pode adicionar mais pressionando <shortcut actionId="ToggleLineBreakpoint"/>.
        IO.println("i = " + i);
    }
}
