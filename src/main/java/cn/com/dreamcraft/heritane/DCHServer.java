package cn.com.dreamcraft.heritane;

import cn.com.dreamcraft.heritane.SQL.Config;
import com.moandjiezana.toml.Toml;
import com.moandjiezana.toml.TomlWriter;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Set;

public class DCHServer implements DedicatedServerModInitializer, IMixinConfigPlugin {
    public static Config DCHConfig;
    @Override
    public void onInitializeServer() {

    }

    @Override
    public void onLoad(String mixinPackage) { // 服务端模式启动时初始化配置文件
        if (DCHConfig != null) return;

        var configFile = FabricLoader.getInstance().getConfigDir().resolve("DCHeritane-Server.toml");
        if (!Files.exists(configFile)) {
            DCHMain.LOGGER.warn("No existed configuration, creating.");
            DCHConfig = new Config();
        } else {
            DCHMain.LOGGER.info("Reading from existed configuration.");
            DCHConfig = new Toml().read(FabricLoader.getInstance().getConfigDir().resolve("DCHeritane-Server.toml").toFile()).to(Config.class);
        }

        // Update config
        try {
            DCHMain.LOGGER.info("Successfully read previous configuration.");
            new TomlWriter().write(DCHConfig, configFile.toFile());
        } catch (IOException e) {
            DCHMain.LOGGER.error("Error occurred during reading Configuration.", e);
        }
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return false;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }
}
