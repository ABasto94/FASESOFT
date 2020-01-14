// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `angular-cli.json`.

export const environment = {
  production: false,
  config: {
    tenant: 'bf208dcb-97e8-4d43-bd72-323680bef25c',
    clientId: '36c9809c-2d4b-40de-88c5-7273580b03f9',
    cacheLocation: 'localStorage',
    redirectUri: 'http://localhost:4200/'
  }
};

