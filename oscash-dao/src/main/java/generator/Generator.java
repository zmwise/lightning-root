package generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: mybatis-plus代码生成器(用于生成entity)<br>
 * 注意:<br>
 *     因为没用mybatis-plus的Service和Controller所以生成完之后要删掉TTT目录
 * @author: lizhiming
 * @since: 2017/11/10
 */
public class Generator {

    protected static Logger LOGGER = LoggerFactory.getLogger(Generator.class);

    private static final String TAB_PREFIX = "t_";

    private static final String UNDER_LINE = "_";

    public static void main(String[] args) {
        String[] models = {"oscash-dao"};
        for (String model : models) {
            /**
             * tabName 更改此参数为生成代码的表名称
             */
            shell(model, "t_user_bank");
        }
    }

    private static void shell(String model,String tabName){
        File file = new File(model);
        String path = file.getAbsolutePath();
        System.out.println("代码生成目录:"+path);

        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(path);//这里写你自己的java目录D://Generator//
        gc.setFileOverride(true);//是否覆盖
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("lizhiming");
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sDao");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert() {
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                return super.processTypeConvert(fieldType);
            }
        });
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/oscash?characterEncoding=utf8");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix(new String[] { "t_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(new String[] { tabName }); // 需要生成的表
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        String tabPackage = getName(tabName,UNDER_LINE);
        pc.setParent("src.main");
        pc.setEntity("java.com.osc.oscashdao.entity"+tabPackage);
        pc.setMapper("java.com.osc.oscashdao.dao"+getName(tabName,UNDER_LINE));
        pc.setXml("resources.mybatis"+getName(tabName,UNDER_LINE));
        pc.setService("java.com.osc.oscashdao.service"+getName(tabName,UNDER_LINE));       //本项目没用，生成之后删掉
        pc.setServiceImpl("java.com.osc.oscashdao.serviceImpl"+getName(tabName,UNDER_LINE));   //本项目没用，生成之后删掉
        pc.setController("java.com.osc.oscashdao.web"+getName(tabName,UNDER_LINE));    //本项目没用，生成之后删掉
        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>(16);
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        mpg.setCfg(cfg);

        // 执行生成
        mpg.execute();

        // 打印注入设置
        System.err.println(mpg.getCfg().getMap().get("abc"));
    }

    /**
     * 根据表名返回包名（包分类）
     * @param tabName 原名
     * @return 返回生成后的包路径名
     *  例如：t_user_bank 返回 .user.bank
     */
    public static String getName(String tabName, String reChar) {
        if(tabName.contains(TAB_PREFIX)){
            tabName = "." + tabName.substring(2).replaceAll(reChar,".");
        }
        return tabName;
    }
}