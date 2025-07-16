export default {
  async fetch(request, env) {
    const url = new URL(request.url);
    const telegramApiUrl = `https://api.telegram.org/bot${env.TELEGRAM_BOT_TOKEN}${url.pathname}${url.search}`;

    const newRequest = new Request(telegramApiUrl, {
      method: request.method,
      headers: request.headers,
      body: request.body,
      cf: {
        // This ensures that the request is not cached by Cloudflare
        cacheTtl: 0,
      },
    });

    return fetch(newRequest);
  },
};
