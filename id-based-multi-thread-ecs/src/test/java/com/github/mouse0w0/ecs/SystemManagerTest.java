package com.github.mouse0w0.ecs;

import com.github.mouse0w0.ecs.component.ComponentManager;
import com.github.mouse0w0.ecs.system.DefaultSystemManager;
import com.github.mouse0w0.ecs.system.SystemManager;

class SystemManagerTest {

    static SystemManager systemManager;
    static EntityManager entityManager;
    static ComponentManager componentManager;

    public static void main(String[] args) {
        entityManager = new DefaultEntityManager();
        componentManager = entityManager.getComponentManager();
        int position = componentManager.register(Position.class);
        int velocity = componentManager.register(Velocity.class);
        systemManager = new DefaultSystemManager(entityManager);
        systemManager.register(new MoveSystem());
        for (int i = 0; i < 0x8000; i++) {
            int entity = entityManager.createEntity();
            componentManager.addComponent(entity, position, new Position(0, 0, 0));
            componentManager.addComponent(entity, velocity, new Velocity(0, 0, 0));
        }
        int count = 0;
        double totalTime = 0;
        while (count < 10000) {
            long startTime = System.nanoTime();
            systemManager.update();
            totalTime += (java.lang.System.nanoTime() - startTime) / 1e6;
            count++;
            System.out.println(count + ":" + totalTime / count);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}