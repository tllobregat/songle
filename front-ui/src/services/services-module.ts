import { Scheduler } from 'simple-job-scheduler';
import { Injector } from 'plume-ts-di';

export default function installServicesModule(injector: Injector) {
  injector.registerSingleton(Scheduler);
}
