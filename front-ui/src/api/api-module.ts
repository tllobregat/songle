import { Injector } from 'plume-ts-di';
import ApiHttpClient from './ApiHttpClient';
import DailyApi from './session/DailyApi';

export default function installApiModule(injector: Injector) {
  injector.registerSingleton(ApiHttpClient);
  injector.registerSingleton(DailyApi);
}
