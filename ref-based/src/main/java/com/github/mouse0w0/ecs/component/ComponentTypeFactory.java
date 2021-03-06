package com.github.mouse0w0.ecs.component;

public interface ComponentTypeFactory {
    ComponentType get(Class<? extends Component> type);

    ComponentType get(int componentId);
}
