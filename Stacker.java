public record Stacker (String word, int value) {
    @Override
    public String toString() {
        return String.format("%-19s%13d%n", this.word(), this.value());
    }
}
