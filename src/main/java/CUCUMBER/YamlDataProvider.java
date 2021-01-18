package CUCUMBER;
import org.yaml.snakeyaml.Yaml;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class YamlDataProvider  {
    public String get(String name) throws IOException {
        Yaml yaml = new Yaml();
        Map<String,String> map = yaml.load(new FileInputStream(new File("src/main/resources/data.yaml")));
        return (map.get(name));
    }
}
