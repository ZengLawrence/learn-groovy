class Services {

    boolean isHeader(String line) {
        line.startsWith("name")
    }
}

Services services = new Services()

assert services.isHeader("name")
assert !services.isHeader("xxx")

return services