interface formatteerStrategie {
    String format(String teFormatterenTekst);
}
class naarHoofdLetters implements formatteerStrategie {
    @Override
    public String format(String teFormatterenTekst) {
        return teFormatterenTekst.toUpperCase();
    }
}
class naarKleineLetters implements formatteerStrategie {

    @Override
    public String format(String teFormatterenTekst) {
        return teFormatterenTekst.toLowerCase();
    }
}
class NaarSnakeCase implements formatteerStrategie {

    @Override
    public String format(String teFormatterenTekst) {
        return teFormatterenTekst.replaceAll("([a-z])([A-Z])", "$1_$2")
                .toLowerCase();
    }
}
class NaarCamelCase implements formatteerStrategie {

    @Override
    public String format(String teFormatterenTekst) {
        String[] woorden = teFormatterenTekst.split("\\s+");
        StringBuilder camelCaseTekst = new StringBuilder(woorden[0].toLowerCase());

        for (int i = 1; i < woorden.length; i++) {
            camelCaseTekst.append(Character.toUpperCase(woorden[i].charAt(0)))
                    .append(woorden[i].substring(1).toLowerCase());
        }

        return camelCaseTekst.toString();
    }
}
class Gebruiker {
    formatteerStrategie strategie;
    public Gebruiker(formatteerStrategie strategie) {
        this.strategie = strategie;
    }
    public String format(String teFormatterenTekst) {
        return strategie.format(teFormatterenTekst);
    }
}
