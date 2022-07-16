const CompressionPlugin = require("compression-webpack-plugin");
const BrotliPlugin = require("brotli-webpack-plugin");

module.exports = {
  plugins: [
    new CompressionPlugin({
      algorithm: "gzip",
    }),
    // new BrotliPlugin(),
    // new CompressionPlugin({
    //   filename: '[path][base].br',
    //   algorithm: 'brotliCompress',
    //   test:  /\.(js|css|html|svg|woff|woff2)$/,
    //   threshold: 10240,
    //   minRatio: 0.8
    // }),
    /*
      replaceDuplicatePlugins: Defaults to false. If true, the plugins in custom webpack config will replace the corresponding
      plugins in default Angular CLI webpack configuration. If false, the default behavior will be applied.
     */
  ],
};
