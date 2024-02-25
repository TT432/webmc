package io.github.tt432.webmc;

import net.neoforged.fml.common.Mod;
import spark.Spark;

@Mod(Webmc.MOD_ID)
public class Webmc {
    public static final String MOD_ID = "webmc";

    public Webmc() {
        Spark.before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            response.header("Access-Control-Allow-Headers", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");
            response.header("Access-Control-Allow-Credentials", "true");
        });

        Spark.get("/api/files", (req, res) -> "[\"file1\"]");
        Spark.get("/api/files/:filename", (req, res) -> """
                [{
                "name": "Field1",
                "type": "int",
                "description": "一个字段",
                "defaultValue": "1",
                "value":"1"
                },{
                "name": "Field2",
                "type": "bool",
                "description": "一个字段",
                "defaultValue": "true",
                "value":"true"
                },{
                "name": "Field3",
                "type": "string",
                "description": "一个字段",
                "defaultValue": "1",
                "value":"1"
                },{
                "name": "Field4",
                "type": "float",
                "description": "一个字段",
                "defaultValue": "1",
                "value":"1"
                }
                ]
                """);
        Spark.post("/api/files/:filename/change/:fieldname/:fieldvalue", (req, res) -> {
            return 0;
        });
    }
}
