package com.github.mouse0w0.ecs.component;

import com.github.mouse0w0.ecs.util.ObjectArray;

public class ComponentMapper {
    private final ComponentType type;
    private final ObjectArray<Component> components;

    public ComponentMapper(ComponentType type) {
        this.type = type;
        this.components = new ObjectArray(type.getType());
    }

    public ComponentType getType() {
        return type;
    }

    public Component get(int entityId) {
        return components.get(entityId);
    }

    public void set(int entityId, Component value) {
        components.unsafeSet(entityId, value);
    }

    public void ensureCapacity(int minCapacity) {
        components.ensureCapacity(minCapacity);
    }
}
